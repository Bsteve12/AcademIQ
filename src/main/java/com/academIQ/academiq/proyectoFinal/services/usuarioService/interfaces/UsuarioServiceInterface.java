package com.academIQ.academiq.proyectoFinal.services.usuarioService.interfaces;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.UsuarioRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.UsuarioResponseDTO;

import java.util.List;

public interface UsuarioServiceInterface {
    UsuarioResponseDTO crear(UsuarioRequestDTO dto);
    UsuarioResponseDTO actualizar(Long id, UsuarioRequestDTO dto);
    UsuarioResponseDTO obtenerPorId(Long id);
    List<UsuarioResponseDTO> listar();
    void eliminar(Long id);
}
