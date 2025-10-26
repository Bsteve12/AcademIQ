package com.academIQ.academiq.proyectoFinal.mapper;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.CalificacionDetalleRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.CalificacionDetalleResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.Calificacion;
import com.academIQ.academiq.proyectoFinal.entity.CalificacionDetalle;
import com.academIQ.academiq.proyectoFinal.entity.EvaluacionItem;
import org.springframework.stereotype.Component;

@Component
public class CalificacionDetalleMapper {

    public CalificacionDetalle toEntity(CalificacionDetalleRequestDTO dto,
                                        EvaluacionItem evaluacionItem,
                                        Calificacion calificacion) {
        return CalificacionDetalle.builder()
                .evaluacionItem(evaluacionItem)
                .calificacion(calificacion)
                .nota(dto.getNota())
                .build();
    }

    public CalificacionDetalleResponseDTO toResponseDTO(CalificacionDetalle detalle) {
        return CalificacionDetalleResponseDTO.builder()
                .id(detalle.getId())
                .evaluacionItemId(detalle.getEvaluacionItem().getId())
                .evaluacionItemDescripcion(detalle.getEvaluacionItem().getNombreItem())
                .calificacionId(detalle.getCalificacion().getId())
                .nota(detalle.getNota())
                .build();
    }
}
