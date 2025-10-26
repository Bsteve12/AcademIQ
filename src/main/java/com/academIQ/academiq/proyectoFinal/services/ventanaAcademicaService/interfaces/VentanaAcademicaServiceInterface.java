package com.academIQ.academiq.proyectoFinal.services.ventanaAcademicaService.interfaces;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.VentanaAcademicaRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.VentanaAcademicaResponseDTO;
import java.util.List;

public interface VentanaAcademicaServiceInterface {
    VentanaAcademicaResponseDTO crear(VentanaAcademicaRequestDTO dto);
    List<VentanaAcademicaResponseDTO> listar();
    VentanaAcademicaResponseDTO buscarPorId(Long id);
    void eliminar(Long id);
}
