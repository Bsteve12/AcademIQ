package com.academIQ.academiq.proyectoFinal.mapper;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.PeriodoRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.PeriodoResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.Periodo;
import org.springframework.stereotype.Component;

@Component
public class PeriodoMapper {

    public Periodo toEntity(PeriodoRequestDTO dto) {
        return Periodo.builder()
                .nombre(dto.getNombre())
                .fechaInicio(dto.getFechaInicio())
                .fechaFin(dto.getFechaFin())
                .activo(dto.isActivo())
                .build();
    }

    public PeriodoResponseDTO toResponseDTO(Periodo periodo) {
        return PeriodoResponseDTO.builder()
                .id(periodo.getId())
                .nombre(periodo.getNombre())
                .fechaInicio(periodo.getFechaInicio())
                .fechaFin(periodo.getFechaFin())
                .activo(periodo.isActivo())
                .build();
    }
}
