package com.academIQ.academiq.proyectoFinal.services.prerrequisitoService.interfaces;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.PrerrequisitoRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.PrerrequisitoResponseDTO;
import java.util.List;

public interface PrerrequisitoServiceInterface {
    PrerrequisitoResponseDTO crear(PrerrequisitoRequestDTO dto);
    List<PrerrequisitoResponseDTO> listar();
    PrerrequisitoResponseDTO buscarPorId(Long id);
    void eliminar(Long id);
}
