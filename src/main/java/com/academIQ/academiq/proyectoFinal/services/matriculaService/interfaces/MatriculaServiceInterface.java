package com.academIQ.academiq.proyectoFinal.services.matriculaService.interfaces;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.MatriculaRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.MatriculaResponseDTO;

import java.util.List;

public interface MatriculaServiceInterface {
    MatriculaResponseDTO crear(MatriculaRequestDTO dto);
    List<MatriculaResponseDTO> listar();
    MatriculaResponseDTO buscarPorId(Long id);
    List<MatriculaResponseDTO> listarPorEstudiante(Long estudianteId);
    void eliminar(Long id);
}
