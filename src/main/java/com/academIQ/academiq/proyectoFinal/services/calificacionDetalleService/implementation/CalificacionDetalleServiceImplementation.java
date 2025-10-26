package com.academIQ.academiq.proyectoFinal.services.calificacionDetalleService.implementation;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.CalificacionDetalleRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.CalificacionDetalleResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.Calificacion;
import com.academIQ.academiq.proyectoFinal.entity.CalificacionDetalle;
import com.academIQ.academiq.proyectoFinal.entity.EvaluacionItem;
import com.academIQ.academiq.proyectoFinal.mapper.CalificacionDetalleMapper;
import com.academIQ.academiq.proyectoFinal.repository.CalificacionDetalleRepository;
import com.academIQ.academiq.proyectoFinal.repository.CalificacionRepository;
import com.academIQ.academiq.proyectoFinal.repository.EvaluacionItemRepository;
import com.academIQ.academiq.proyectoFinal.services.calificacionDetalleService.interfaces.CalificacionDetalleServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CalificacionDetalleServiceImplementation implements CalificacionDetalleServiceInterface {

    private final CalificacionDetalleRepository detalleRepository;
    private final EvaluacionItemRepository evaluacionItemRepository;
    private final CalificacionRepository calificacionRepository;
    private final CalificacionDetalleMapper detalleMapper;

    @Override
    public CalificacionDetalleResponseDTO crear(CalificacionDetalleRequestDTO dto) {
        EvaluacionItem item = evaluacionItemRepository.findById(dto.getEvaluacionItemId())
                .orElseThrow(() -> new EntityNotFoundException("EvaluacionItem no encontrado con ID: " + dto.getEvaluacionItemId()));

        Calificacion calificacion = calificacionRepository.findById(dto.getCalificacionId())
                .orElseThrow(() -> new EntityNotFoundException("Calificacion no encontrada con ID: " + dto.getCalificacionId()));

        // Validación de rango de nota ya aplicada por DTO, validación extra en backend:
        if (dto.getNota() < 0.0 || dto.getNota() > 5.0) {
            throw new IllegalArgumentException("La nota debe estar entre 0.0 y 5.0");
        }

        CalificacionDetalle detalle = detalleMapper.toEntity(dto, item, calificacion);
        CalificacionDetalle guardado = detalleRepository.save(detalle);

        //  En Oracle (exclusivo):
        // 1) Recalcular nota_final de la calificación padre (por ejemplo, mediante TRIGGER AFTER INSERT/UPDATE en CALIFICACIONES_DETALLE)
        //    - Puede ser un promedio ponderado según pesos almacenados en EVALUACION_ITEM.
        //    - Ejemplo: UPDATE CALIFICACIONES SET NOTA_FINAL = <cálculo> WHERE ID = :CALIFICACION_ID;
        // 2) Validar coherencia de ítems (por ejemplo: no insertar dos detalles para el mismo evaluacion_item y calificacion si eso no está permitido).
        // 3) Triggers de auditoría (quién insertó la nota_detalle y cuándo).
        // 4) Ejecutar procedimientos que actualicen otros agregados (p. ej. estado de la matrícula si nota_final >= nota_aprobatoria).
        //
        // Resumen: el backend puede insertar el detalle y validar rangos/entidades, pero el **cálculo correcto y atómico de la nota_final**
        // y las reglas multi-tabla deben residir en Oracle para garantizar integridad transaccional.

        return detalleMapper.toResponseDTO(guardado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CalificacionDetalleResponseDTO> listar() {
        return detalleRepository.findAll().stream()
                .map(detalleMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public CalificacionDetalleResponseDTO buscarPorId(Long id) {
        CalificacionDetalle detalle = detalleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("CalificacionDetalle no encontrado con ID: " + id));
        return detalleMapper.toResponseDTO(detalle);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CalificacionDetalleResponseDTO> listarPorCalificacion(Long calificacionId) {
        return detalleRepository.findByCalificacionId(calificacionId).stream()
                .map(detalleMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CalificacionDetalleResponseDTO actualizar(Long id, CalificacionDetalleRequestDTO dto) {
        CalificacionDetalle existente = detalleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("CalificacionDetalle no encontrado con ID: " + id));

        EvaluacionItem item = evaluacionItemRepository.findById(dto.getEvaluacionItemId())
                .orElseThrow(() -> new EntityNotFoundException("EvaluacionItem no encontrado con ID: " + dto.getEvaluacionItemId()));

        Calificacion calificacion = calificacionRepository.findById(dto.getCalificacionId())
                .orElseThrow(() -> new EntityNotFoundException("Calificacion no encontrada con ID: " + dto.getCalificacionId()));

        if (dto.getNota() < 0.0 || dto.getNota() > 5.0) {
            throw new IllegalArgumentException("La nota debe estar entre 0.0 y 5.0");
        }

        existente.setEvaluacionItem(item);
        existente.setCalificacion(calificacion);
        existente.setNota(dto.getNota());

        CalificacionDetalle actualizado = detalleRepository.save(existente);

        //  En Oracle: Trigger AFTER UPDATE recalcula nota_final en CALIFICACIONES y realiza auditoría.

        return detalleMapper.toResponseDTO(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        CalificacionDetalle existente = detalleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("CalificacionDetalle no encontrado con ID: " + id));

        detalleRepository.delete(existente);

        //  En Oracle:
        // - Trigger AFTER DELETE debe recalcular nota_final de la calificación padre.
        // - Registrar en BITACORA la eliminación y controlar políticas (por ejemplo, no permitir borrar si ya se cerró acta).
    }
}
