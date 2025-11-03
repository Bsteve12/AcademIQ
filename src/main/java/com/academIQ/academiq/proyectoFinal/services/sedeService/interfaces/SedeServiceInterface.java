package com.academIQ.academiq.proyectoFinal.services.sedeService.interfaces;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.SedeRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.SedeResponseDTO;
import java.util.List;

public interface SedeServiceInterface {

    SedeResponseDTO crear(SedeRequestDTO dto);
    List<SedeResponseDTO> listar();
    SedeResponseDTO buscarPorId(Long id);
    void eliminar(Long id);
}
