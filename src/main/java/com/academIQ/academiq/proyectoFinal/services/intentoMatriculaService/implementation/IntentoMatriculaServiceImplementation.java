package com.academIQ.academiq.proyectoFinal.services.intentoMatriculaService.implementation;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.IntentoMatriculaRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.IntentoMatriculaResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.*;
import com.academIQ.academiq.proyectoFinal.mapper.IntentoMatriculaMapper;
import com.academIQ.academiq.proyectoFinal.repository.*;
import com.academIQ.academiq.proyectoFinal.services.intentoMatriculaService.interfaces.IntentoMatriculaServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IntentoMatriculaServiceImplementation implements IntentoMatriculaServiceInterface {

    private final IntentoMatriculaRepository intentoRepository;
    private final EstudianteRepository estudianteRepository;
    private final GrupoRepository grupoRepository;
    private final IntentoMatriculaMapper mapper;

    @Override
    public IntentoMatriculaResponseDTO registrar(IntentoMatriculaRequestDTO dto) {
        Estudiante estudiante = estudianteRepository.findById(dto.getEstudianteId())
                .orElseThrow(() -> new EntityNotFoundException("Estudiante no encontrado"));
        Grupo grupo = grupoRepository.findById(dto.getGrupoId())
                .orElseThrow(() -> new EntityNotFoundException("Grupo no encontrado"));

        //  Lógica de validación previa (que sí se puede hacer en Java):
        // - Verificar si el grupo tiene cupos disponibles.
        // - Validar si el estudiante ya está matriculado en esa asignatura.
        // - Verificar posibles choques de horario con otros grupos del estudiante.

        //  Lógica que se debe implementar exclusivamente en ORACLE:
        // - Reglas de negocio complejas (por ejemplo, validación de riesgo académico).
        // - Registro automático en la tabla de auditoría (BITÁCORA).
        // - Procedimiento almacenado para registrar intento y determinar si fue exitoso.

        IntentoMatricula intento = mapper.toEntity(dto, estudiante, grupo);
        intentoRepository.save(intento);
        return mapper.toResponseDTO(intento);
    }

    @Override
    public List<IntentoMatriculaResponseDTO> listar() {
        return intentoRepository.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public IntentoMatriculaResponseDTO buscarPorId(Long id) {
        IntentoMatricula intento = intentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Intento no encontrado"));
        return mapper.toResponseDTO(intento);
    }

    @Override
    public void eliminar(Long id) {
        IntentoMatricula intento = intentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Intento no encontrado"));
        intentoRepository.delete(intento);
    }
}
