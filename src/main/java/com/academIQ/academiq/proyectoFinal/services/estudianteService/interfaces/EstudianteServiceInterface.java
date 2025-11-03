package com.academIQ.academiq.proyectoFinal.services.estudianteService.interfaces;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.EstudianteRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.EstudianteResponseDTO;

import java.util.List;

public interface EstudianteServiceInterface {
    EstudianteResponseDTO crear(EstudianteRequestDTO dto);
    List<EstudianteResponseDTO> listar();
    EstudianteResponseDTO buscarPorId(Long id);
    void eliminar(Long id);
}