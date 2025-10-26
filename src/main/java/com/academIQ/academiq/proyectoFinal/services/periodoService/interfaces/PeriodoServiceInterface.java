package com.academIQ.academiq.proyectoFinal.services.periodoService.interfaces;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.PeriodoRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.PeriodoResponseDTO;

import java.util.List;

public interface PeriodoServiceInterface {
    PeriodoResponseDTO crear(PeriodoRequestDTO dto);
    List<PeriodoResponseDTO> listar();
    PeriodoResponseDTO buscarPorId(Long id);
    PeriodoResponseDTO obtenerPeriodoActivo();
    void eliminar(Long id);
}
