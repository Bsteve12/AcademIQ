package com.academIQ.academiq.proyectoFinal.services.calificacionService.interfaces;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.CalificacionRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.CalificacionResponseDTO;

import java.util.List;

public interface CalificacionServiceInterface {
    CalificacionResponseDTO crear(CalificacionRequestDTO dto);
    CalificacionResponseDTO actualizar(Long id, CalificacionRequestDTO dto);
    CalificacionResponseDTO buscarPorId(Long id);
    List<CalificacionResponseDTO> listar();
    void eliminar(Long id);
}
