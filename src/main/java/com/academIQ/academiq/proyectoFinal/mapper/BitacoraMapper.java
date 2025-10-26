package com.academIQ.academiq.proyectoFinal.mapper;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.BitacoraRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.BitacoraResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.Bitacora;
import com.academIQ.academiq.proyectoFinal.entity.Usuario;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class BitacoraMapper {

    public Bitacora toEntity(BitacoraRequestDTO dto, Usuario usuario) {
        return Bitacora.builder()
                .accion(dto.getAccion())
                .entidad(dto.getEntidad())
                .entidadId(dto.getEntidadId())
                .detalle(dto.getDetalle())
                .ip(dto.getIp())
                .fechaHora(LocalDateTime.now())
                .usuario(usuario)
                .build();
    }

    public BitacoraResponseDTO toResponseDTO(Bitacora entity) {
        return BitacoraResponseDTO.builder()
                .id(entity.getId())
                .accion(entity.getAccion())
                .entidad(entity.getEntidad())
                .entidadId(entity.getEntidadId())
                .detalle(entity.getDetalle())
                .ip(entity.getIp())
                .fechaHora(entity.getFechaHora())
                .usuarioNombre(entity.getUsuario() != null ? entity.getUsuario().getNombreCompleto() : "Desconocido")
                .build();
    }
}
