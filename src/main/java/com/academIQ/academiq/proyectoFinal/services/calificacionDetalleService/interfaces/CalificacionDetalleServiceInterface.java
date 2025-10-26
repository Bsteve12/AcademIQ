package com.academIQ.academiq.proyectoFinal.services.calificacionDetalleService.interfaces;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.CalificacionDetalleRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.CalificacionDetalleResponseDTO;

import java.util.List;

public interface CalificacionDetalleServiceInterface {
    CalificacionDetalleResponseDTO crear(CalificacionDetalleRequestDTO dto);
    CalificacionDetalleResponseDTO actualizar(Long id, CalificacionDetalleRequestDTO dto);
    CalificacionDetalleResponseDTO buscarPorId(Long id);
    List<CalificacionDetalleResponseDTO> listar();
    List<CalificacionDetalleResponseDTO> listarPorCalificacion(Long calificacionId);
    void eliminar(Long id);
}
