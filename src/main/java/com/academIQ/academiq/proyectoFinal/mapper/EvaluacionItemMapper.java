package com.academIQ.academiq.proyectoFinal.mapper;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.EvaluacionItemRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.EvaluacionItemResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.Asignatura;
import com.academIQ.academiq.proyectoFinal.entity.EvaluacionItem;
import org.springframework.stereotype.Component;

@Component
public class EvaluacionItemMapper {

    public EvaluacionItem toEntity(EvaluacionItemRequestDTO dto, Asignatura asignatura) {
        return EvaluacionItem.builder()
                .nombreItem(dto.getNombreItem())
                .descripcion(dto.getDescripcion())
                .porcentaje(dto.getPorcentaje())
                .fechaRegistro(dto.getFechaRegistro())
                .asignatura(asignatura)
                .build();
    }

    public EvaluacionItemResponseDTO toResponseDTO(EvaluacionItem entity) {
        return EvaluacionItemResponseDTO.builder()
                .id(entity.getId())
                .nombreItem(entity.getNombreItem())
                .descripcion(entity.getDescripcion())
                .porcentaje(entity.getPorcentaje())
                .fechaRegistro(entity.getFechaRegistro())
                .asignaturaNombre(
                        entity.getAsignatura() != null ? entity.getAsignatura().getNombre() : "Sin asignatura"
                )
                .build();
    }
}
