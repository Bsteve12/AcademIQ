package com.academIQ.academiq.proyectoFinal.services.evaluacionItemService.implementation;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.EvaluacionItemRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.EvaluacionItemResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.Asignatura;
import com.academIQ.academiq.proyectoFinal.entity.EvaluacionItem;
import com.academIQ.academiq.proyectoFinal.mapper.EvaluacionItemMapper;
import com.academIQ.academiq.proyectoFinal.repository.AsignaturaRepository;
import com.academIQ.academiq.proyectoFinal.repository.EvaluacionItemRepository;
import com.academIQ.academiq.proyectoFinal.services.evaluacionItemService.interfaces.EvaluacionItemServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class EvaluacionItemServiceImplementation implements EvaluacionItemServiceInterface {

    private final EvaluacionItemRepository evaluacionItemRepository;
    private final AsignaturaRepository asignaturaRepository;
    private final EvaluacionItemMapper evaluacionItemMapper;

    @Override
    public EvaluacionItemResponseDTO crear(EvaluacionItemRequestDTO dto) {
        Asignatura asignatura = asignaturaRepository.findById(dto.getAsignaturaId())
                .orElseThrow(() -> new EntityNotFoundException("Asignatura no encontrada con ID: " + dto.getAsignaturaId()));

        if (dto.getFechaRegistro() == null) {
            dto.setFechaRegistro(LocalDate.now());
        }

        EvaluacionItem item = evaluacionItemMapper.toEntity(dto, asignatura);
        EvaluacionItem guardado = evaluacionItemRepository.save(item);

        //  EN ORACLE (EXCLUSIVO):
        // 1 Trigger o procedimiento que valide que la suma de porcentajes de los ítems de una asignatura <= 100.
        //    - Ejemplo: BEFORE INSERT/UPDATE en EVALUACIONES_ITEMS
        //    - Si supera 100%, lanzar excepción ORA personalizada.
        // 2 Auditoría: registrar usuario que crea/modifica el ítem.
        // 3⃣  Vistas o procedimientos que devuelvan distribución de evaluación por asignatura.

        return evaluacionItemMapper.toResponseDTO(guardado);
    }

    @Override
    public EvaluacionItemResponseDTO actualizar(Long id, EvaluacionItemRequestDTO dto) {
        EvaluacionItem existente = evaluacionItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("EvaluacionItem no encontrado con ID: " + id));

        existente.setNombreItem(dto.getNombreItem());
        existente.setPorcentaje(dto.getPorcentaje());
        existente.setFechaRegistro(dto.getFechaRegistro() != null ? dto.getFechaRegistro() : LocalDate.now());

        EvaluacionItem actualizado = evaluacionItemRepository.save(existente);

        //  EN ORACLE:
        // - Trigger AFTER UPDATE recalcula porcentaje total y evita sobrepasar 100%.
        // - Registro de auditoría en BITACORA.

        return evaluacionItemMapper.toResponseDTO(actualizado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EvaluacionItemResponseDTO> listar() {
        return evaluacionItemRepository.findAll()
                .stream()
                .map(evaluacionItemMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<EvaluacionItemResponseDTO> listarPorAsignatura(Long asignaturaId) {
        return evaluacionItemRepository.findByAsignaturaId(asignaturaId)
                .stream()
                .map(evaluacionItemMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public EvaluacionItemResponseDTO buscarPorId(Long id) {
        EvaluacionItem item = evaluacionItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("EvaluacionItem no encontrado con ID: " + id));
        return evaluacionItemMapper.toResponseDTO(item);
    }

    @Override
    public void eliminar(Long id) {
        EvaluacionItem item = evaluacionItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("EvaluacionItem no encontrado con ID: " + id));

        evaluacionItemRepository.delete(item);

        //  EN ORACLE:
        // - Trigger AFTER DELETE para verificar si quedan ítems de evaluación activos.
        // - Actualizar bitácora de cambios y asegurar que no se elimine si existen CalificacionDetalle asociados.
    }
}
