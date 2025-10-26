package com.academIQ.academiq.proyectoFinal.mapper;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.VentanaAcademicaRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.VentanaAcademicaResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.Periodo;
import com.academIQ.academiq.proyectoFinal.entity.VentanaAcademica;
import org.springframework.stereotype.Component;

@Component
public class VentanaAcademicaMapper {

    public VentanaAcademica toEntity(VentanaAcademicaRequestDTO dto, Periodo periodo) {
        return VentanaAcademica.builder()
                .periodo(periodo)
                .fechaInicioInscripcion(dto.getFechaInicioInscripcion())
                .fechaFinInscripcion(dto.getFechaFinInscripcion())
                .fechaInicioRetiros(dto.getFechaInicioRetiros())
                .fechaFinRetiros(dto.getFechaFinRetiros())
                .build();
    }

    public VentanaAcademicaResponseDTO toResponseDTO(VentanaAcademica entity) {
        return VentanaAcademicaResponseDTO.builder()
                .id(entity.getId())
                .periodoNombre(entity.getPeriodo() != null ? entity.getPeriodo().getNombre() : "Sin periodo")
                .fechaInicioInscripcion(entity.getFechaInicioInscripcion())
                .fechaFinInscripcion(entity.getFechaFinInscripcion())
                .fechaInicioRetiros(entity.getFechaInicioRetiros())
                .fechaFinRetiros(entity.getFechaFinRetiros())
                .build();
    }
}
