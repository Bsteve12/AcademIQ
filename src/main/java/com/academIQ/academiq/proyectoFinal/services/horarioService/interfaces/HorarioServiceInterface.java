package com.academIQ.academiq.proyectoFinal.services.horarioService.interfaces;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.HorarioRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.HorarioResponseDTO;

import java.util.List;

public interface HorarioServiceInterface {
    HorarioResponseDTO crear(HorarioRequestDTO dto);
    List<HorarioResponseDTO> listar();
    HorarioResponseDTO buscarPorId(Long id);
    void eliminar(Long id);
}
