package com.academIQ.academiq.proyectoFinal.services.bitacoraService.interfaces;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.BitacoraRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.BitacoraResponseDTO;

import java.util.List;

public interface BitacoraServiceInterface {
    BitacoraResponseDTO registrar(BitacoraRequestDTO dto);
    List<BitacoraResponseDTO> listar();
}
