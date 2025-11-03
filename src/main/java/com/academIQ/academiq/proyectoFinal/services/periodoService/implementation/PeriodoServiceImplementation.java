package com.academIQ.academiq.proyectoFinal.services.periodoService.implementation;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.PeriodoRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.PeriodoResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.Periodo;
import com.academIQ.academiq.proyectoFinal.mapper.PeriodoMapper;
import com.academIQ.academiq.proyectoFinal.repository.PeriodoRepository;
import com.academIQ.academiq.proyectoFinal.services.periodoService.interfaces.PeriodoServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PeriodoServiceImplementation implements PeriodoServiceInterface {

    private final PeriodoRepository periodoRepository;
    private final PeriodoMapper periodoMapper;

    @Override
    public PeriodoResponseDTO crear(PeriodoRequestDTO dto) {
        // Validación básica: las fechas deben tener coherencia
        if (dto.getFechaInicio().isAfter(dto.getFechaFin())) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin.");
        }

        // Si se marca como activo, se debe desactivar el anterior (Oracle lo reforzará)
        if (dto.isActivo()) {
            periodoRepository.findByActivoTrue().ifPresent(p -> p.setActivo(false));
        }

        Periodo periodo = periodoMapper.toEntity(dto);
        periodoRepository.save(periodo);
        return periodoMapper.toResponseDTO(periodo);
    }

    @Override
    public List<PeriodoResponseDTO> listar() {
        return periodoRepository.findAll()
                .stream()
                .map(periodoMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PeriodoResponseDTO buscarPorId(Long id) {
        Periodo periodo = periodoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Periodo no encontrado"));
        return periodoMapper.toResponseDTO(periodo);
    }

    @Override
    public PeriodoResponseDTO obtenerPeriodoActivo() {
        return periodoRepository.findByActivoTrue()
                .map(periodoMapper::toResponseDTO)
                .orElseThrow(() -> new EntityNotFoundException("No hay periodo activo actualmente"));
    }

    @Override
    public void eliminar(Long id) {
        Periodo periodo = periodoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Periodo no encontrado"));
        periodoRepository.delete(periodo);
    }

    /*
      En Oracle (exclusivo):
     1. Crear un trigger que garantice que solo puede haber un periodo con ACTIVO = TRUE.
     2. Crear un procedimiento almacenado para activar/desactivar periodos.
     3. Crear vistas para consultar el historial de periodos académicos.
     4. Controlar mediante roles quién puede cerrar o abrir periodos (Administrador Académico).
     */
}
