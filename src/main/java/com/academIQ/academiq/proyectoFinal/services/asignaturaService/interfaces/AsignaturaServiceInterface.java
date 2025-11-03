package com.academIQ.academiq.proyectoFinal.services.asignaturaService.interfaces;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.AsignaturaRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.AsignaturaResponseDTO;

import java.util.List;

public interface AsignaturaServiceInterface {
    AsignaturaResponseDTO crear(AsignaturaRequestDTO dto);
    List<AsignaturaResponseDTO> listar();
    AsignaturaResponseDTO buscarPorId(Long id);
    void eliminar(Long id);
}
