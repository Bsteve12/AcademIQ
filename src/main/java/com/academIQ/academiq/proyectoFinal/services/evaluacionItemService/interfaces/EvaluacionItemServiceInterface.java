package com.academIQ.academiq.proyectoFinal.services.evaluacionItemService.interfaces;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.EvaluacionItemRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.EvaluacionItemResponseDTO;

import java.util.List;

public interface EvaluacionItemServiceInterface {
    EvaluacionItemResponseDTO crear(EvaluacionItemRequestDTO dto);
    EvaluacionItemResponseDTO actualizar(Long id, EvaluacionItemRequestDTO dto);
    List<EvaluacionItemResponseDTO> listar();
    List<EvaluacionItemResponseDTO> listarPorAsignatura(Long asignaturaId);
    EvaluacionItemResponseDTO buscarPorId(Long id);
    void eliminar(Long id);
}
