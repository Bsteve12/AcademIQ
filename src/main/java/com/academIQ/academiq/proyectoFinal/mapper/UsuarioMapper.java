package com.academIQ.academiq.proyectoFinal.mapper;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.UsuarioRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.UsuarioResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toEntity(UsuarioRequestDTO dto) {
        return Usuario.builder()
                .username(dto.getUsername())
                .password(dto.getPassword()) // ⚠️ Se encriptará antes de guardar en el servicio
                .nombreCompleto(dto.getNombreCompleto())
                .correo(dto.getCorreo())
                .rol(dto.getRol())
                .activo(true)
                .build();
    }

    public UsuarioResponseDTO toResponseDTO(Usuario usuario) {
        return UsuarioResponseDTO.builder()
                .id(usuario.getId())
                .username(usuario.getUsername())
                .nombreCompleto(usuario.getNombreCompleto())
                .correo(usuario.getCorreo())
                .rol(usuario.getRol())
                .activo(usuario.isActivo())
                .build();
    }
}
