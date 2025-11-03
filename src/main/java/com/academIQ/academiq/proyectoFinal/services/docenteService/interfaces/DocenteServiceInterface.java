package com.academIQ.academiq.proyectoFinal.services.docenteService.interfaces;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.DocenteRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.DocenteResponseDTO;

import java.util.List;

public interface DocenteServiceInterface {
    DocenteResponseDTO crear(DocenteRequestDTO dto);
    DocenteResponseDTO editar(Long id, DocenteRequestDTO dto);
    List<DocenteResponseDTO> listar();
    DocenteResponseDTO buscarPorId(Long id);
    void eliminar(Long id);
}
