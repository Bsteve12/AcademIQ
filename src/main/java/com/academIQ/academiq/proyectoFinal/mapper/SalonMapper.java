package com.academIQ.academiq.proyectoFinal.mapper;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.SalonRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.SalonResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.Salon;
import com.academIQ.academiq.proyectoFinal.entity.Sede;
import org.springframework.stereotype.Component;

@Component
public class SalonMapper {

    public Salon toEntity(SalonRequestDTO dto, Sede sede) {
        return Salon.builder()
                .nombre(dto.getNombre())
                .ubicacion(dto.getUbicacion())
                .capacidad(dto.getCapacidad())
                .sede(sede)
                .build();
    }

    public SalonResponseDTO toResponseDTO(Salon salon) {
        return SalonResponseDTO.builder()
                .id(salon.getId())
                .nombre(salon.getNombre())
                .ubicacion(salon.getUbicacion())
                .capacidad(salon.getCapacidad())
                .sede(salon.getSede() != null ? salon.getSede().getNombre() : "Sin sede")
                .build();
    }
}
