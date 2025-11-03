package com.academIQ.academiq.proyectoFinal.mapper;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.ProgramaRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.ProgramaResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.Programa;
import com.academIQ.academiq.proyectoFinal.entity.Sede;
import org.springframework.stereotype.Component;

@Component
public class ProgramaMapper {

    /**
     * Convierte RequestDTO -> Entity.
     * Nota: la Sede debe resolverse por el servicio y pasarse aquí.
     */
    public Programa toEntity(ProgramaRequestDTO dto, Sede sede) {
        return Programa.builder()
                .nombre(dto.getNombre())
                .facultad(dto.getFacultad())
                .duracionSemestres(dto.getDuracionSemestres())
                .sede(sede)
                .build();
    }

    /**
     * Convierte Entity -> ResponseDTO.
     */
    public ProgramaResponseDTO toResponseDTO(Programa programa) {
        Integer count = null;
        if (programa.getEstudiantes() != null) {
            count = programa.getEstudiantes().size();
        }
        return ProgramaResponseDTO.builder()
                .id(programa.getId())
                .nombre(programa.getNombre())
                .facultad(programa.getFacultad())
                .duracionSemestres(programa.getDuracionSemestres())
                .sede(programa.getSede() != null ? programa.getSede().getNombre() : "Sin sede")
                .estudiantesCount(count)
                .build();
    }
}
