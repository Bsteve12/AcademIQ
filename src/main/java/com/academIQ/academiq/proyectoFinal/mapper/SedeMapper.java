package com.academIQ.academiq.proyectoFinal.mapper;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.SedeRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.SedeResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.Sede;
import org.springframework.stereotype.Component;

@Component
public class SedeMapper {

    public Sede toEntity(SedeRequestDTO dto) {
        return Sede.builder()
                .nombre(dto.getNombre())
                .direccion(dto.getDireccion())
                .ciudad(dto.getCiudad())
                .build();
    }

    public SedeResponseDTO toResponseDTO(Sede sede) {
        return SedeResponseDTO.builder()
                .id(sede.getId())
                .nombre(sede.getNombre())
                .direccion(sede.getDireccion())
                .ciudad(sede.getCiudad())
                .build();
    }
}
