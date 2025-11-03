package com.academIQ.academiq.proyectoFinal.services.historialService.interfaces;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.HistorialAcademicoRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.HistorialAcademicoResponseDTO;

import java.util.List;

public interface HistorialAcademicoServiceInterface {
    HistorialAcademicoResponseDTO registrar(HistorialAcademicoRequestDTO dto);
    List<HistorialAcademicoResponseDTO> listar();
    HistorialAcademicoResponseDTO buscarPorId(Long id);
    void eliminar(Long id);
}
