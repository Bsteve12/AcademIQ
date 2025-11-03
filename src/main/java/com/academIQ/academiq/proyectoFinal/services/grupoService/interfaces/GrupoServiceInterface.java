package com.academIQ.academiq.proyectoFinal.services.grupoService.interfaces;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.GrupoRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.GrupoResponseDTO;

import java.util.List;

public interface GrupoServiceInterface {
    GrupoResponseDTO crear(GrupoRequestDTO dto);
    List<GrupoResponseDTO> listar();
    GrupoResponseDTO buscarPorId(Long id);
    void eliminar(Long id);
}
