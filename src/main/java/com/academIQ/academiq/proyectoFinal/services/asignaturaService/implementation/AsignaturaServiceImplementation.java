package com.academIQ.academiq.proyectoFinal.services.asignaturaService.implementation;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.AsignaturaRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.AsignaturaResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.Asignatura;
import com.academIQ.academiq.proyectoFinal.entity.Programa;
import com.academIQ.academiq.proyectoFinal.mapper.AsignaturaMapper;
import com.academIQ.academiq.proyectoFinal.repository.AsignaturaRepository;
import com.academIQ.academiq.proyectoFinal.repository.ProgramaRepository;
import com.academIQ.academiq.proyectoFinal.services.asignaturaService.interfaces.AsignaturaServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AsignaturaServiceImplementation implements AsignaturaServiceInterface {

    private final AsignaturaRepository asignaturaRepository;
    private final ProgramaRepository programaRepository;
    private final AsignaturaMapper asignaturaMapper;

    @Override
    public AsignaturaResponseDTO crear(AsignaturaRequestDTO dto) {
        if (asignaturaRepository.existsByCodigo(dto.getCodigo())) {
            throw new IllegalArgumentException("Ya existe una asignatura con el código: " + dto.getCodigo());
        }

        Programa programa = programaRepository.findById(dto.getProgramaId())
                .orElseThrow(() -> new EntityNotFoundException("Programa no encontrado con ID: " + dto.getProgramaId()));

        Asignatura asignatura = asignaturaMapper.toEntity(dto, programa);
        asignaturaRepository.save(asignatura);

        return asignaturaMapper.toResponseDTO(asignatura);
    }

    @Override
    public List<AsignaturaResponseDTO> listar() {
        return asignaturaRepository.findAll()
                .stream()
                .map(asignaturaMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AsignaturaResponseDTO buscarPorId(Long id) {
        Asignatura asignatura = asignaturaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Asignatura no encontrada con ID: " + id));

        return asignaturaMapper.toResponseDTO(asignatura);
    }

    @Override
    public void eliminar(Long id) {
        Asignatura asignatura = asignaturaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Asignatura no encontrada con ID: " + id));
        asignaturaRepository.delete(asignatura);
    }
}
//     ORACLE
//  Crear tabla intermedia DOCENTE_ASIGNATURA para la relación N:M entre docentes y asignaturas.
//  Crear tabla PRERREQUISITO para enlazar asignaturas entre sí.
//  Crear triggers que validen cupos o créditos máximos por semestre.
//  Crear vistas para listar asignaturas con su programa y docente asignado.
//  Crear procedimientos almacenados para matrícula automática o cálculo de créditos.
