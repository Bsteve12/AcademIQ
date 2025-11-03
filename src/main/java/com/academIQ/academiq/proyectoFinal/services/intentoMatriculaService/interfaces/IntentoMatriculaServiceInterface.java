package com.academIQ.academiq.proyectoFinal.services.intentoMatriculaService.interfaces;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.IntentoMatriculaRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.IntentoMatriculaResponseDTO;

import java.util.List;

public interface IntentoMatriculaServiceInterface {
    IntentoMatriculaResponseDTO registrar(IntentoMatriculaRequestDTO dto);
    List<IntentoMatriculaResponseDTO> listar();
    IntentoMatriculaResponseDTO buscarPorId(Long id);
    void eliminar(Long id);
}
