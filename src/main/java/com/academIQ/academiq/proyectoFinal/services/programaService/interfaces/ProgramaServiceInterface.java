package com.academIQ.academiq.proyectoFinal.services.programaService.interfaces;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.ProgramaRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.ProgramaResponseDTO;

import java.util.List;

public interface ProgramaServiceInterface {
    ProgramaResponseDTO crear(ProgramaRequestDTO dto);
    ProgramaResponseDTO editar(Long id, ProgramaRequestDTO dto);
    List<ProgramaResponseDTO> listar();
    ProgramaResponseDTO buscarPorId(Long id);
    void eliminar(Long id);
}
