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
                .porcentaje(dto.getPorcentaje())
                .fechaRegistro(dto.getFechaRegistro())
                .asignatura(asignatura)
                .build();
    }

    public EvaluacionItemResponseDTO toResponseDTO(EvaluacionItem item) {
        return EvaluacionItemResponseDTO.builder()
                .id(item.getId())
                .nombreItem(item.getNombreItem())
                .porcentaje(item.getPorcentaje())
                .fechaRegistro(item.getFechaRegistro())
                .asignaturaId(item.getAsignatura().getId())
                .asignaturaNombre(item.getAsignatura().getNombre())
                .build();
    }
}
