package com.academIQ.academiq.proyectoFinal.services.salonService.interfaces;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.SalonRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.SalonResponseDTO;

import java.util.List;

public interface SalonServiceInterface {
    SalonResponseDTO crear(SalonRequestDTO dto);
    SalonResponseDTO editar(Long id, SalonRequestDTO dto);
    List<SalonResponseDTO> listar();
    SalonResponseDTO buscarPorId(Long id);
    void eliminar(Long id);
}
