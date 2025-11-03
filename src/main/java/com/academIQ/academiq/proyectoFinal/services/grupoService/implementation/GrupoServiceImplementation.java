package com.academIQ.academiq.proyectoFinal.services.grupoService.implementation;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.GrupoRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.GrupoResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.*;
import com.academIQ.academiq.proyectoFinal.mapper.GrupoMapper;
import com.academIQ.academiq.proyectoFinal.repository.*;
import com.academIQ.academiq.proyectoFinal.services.grupoService.interfaces.GrupoServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class GrupoServiceImplementation implements GrupoServiceInterface {

    private final GrupoRepository grupoRepository;
    private final AsignaturaRepository asignaturaRepository;
    private final DocenteRepository docenteRepository;
    private final PeriodoRepository periodoRepository;
    private final SalonRepository salonRepository;
    private final GrupoMapper grupoMapper;

    @Override
    public GrupoResponseDTO crear(GrupoRequestDTO dto) {
        Asignatura asignatura = asignaturaRepository.findById(dto.getAsignaturaId())
                .orElseThrow(() -> new EntityNotFoundException("Asignatura no encontrada"));
        Docente docente = docenteRepository.findById(dto.getDocenteId())
                .orElseThrow(() -> new EntityNotFoundException("Docente no encontrado"));
        Periodo periodo = periodoRepository.findById(dto.getPeriodoId())
                .orElseThrow(() -> new EntityNotFoundException("Periodo no encontrado"));
        Salon salon = (dto.getSalonId() != null)
                ? salonRepository.findById(dto.getSalonId()).orElse(null)
                : null;

        // 🔹 Validación básica: código de grupo único
        grupoRepository.findByCodigoGrupo(dto.getCodigoGrupo()).ifPresent(g -> {
            throw new IllegalArgumentException("Ya existe un grupo con el código " + dto.getCodigoGrupo());
        });

        Grupo grupo = grupoMapper.toEntity(dto, asignatura, docente, periodo, salon);
        grupoRepository.save(grupo);
        return grupoMapper.toResponseDTO(grupo);
    }

    @Override
    public List<GrupoResponseDTO> listar() {
        return grupoRepository.findAll()
                .stream()
                .map(grupoMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public GrupoResponseDTO buscarPorId(Long id) {
        Grupo grupo = grupoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Grupo no encontrado"));
        return grupoMapper.toResponseDTO(grupo);
    }

    @Override
    public void eliminar(Long id) {
        Grupo grupo = grupoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Grupo no encontrado"));
        grupoRepository.delete(grupo);
    }

    //  En Oracle (exclusivo):
    // 1. Control de CUPOS: triggers que impidan superar el cupo máximo en matrícula.
    // 2. Validación de conflictos de horario (cruces de horas, salones ocupados, docentes en dos grupos a la vez).
    // 3. Procedimientos almacenados para actualizar el cupo_actual automáticamente cuando se realiza una matrícula.
    // 4. Vistas que muestren: grupos por asignatura, grupos llenos, disponibilidad por salón, etc.
    // 5. Control de permisos (roles para registrar o eliminar grupos).
}
