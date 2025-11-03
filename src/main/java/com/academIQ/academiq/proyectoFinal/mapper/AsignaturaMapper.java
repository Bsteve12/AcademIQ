package com.academIQ.academiq.proyectoFinal.mapper;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.AsignaturaRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.AsignaturaResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.Asignatura;
import com.academIQ.academiq.proyectoFinal.entity.Programa;
import org.springframework.stereotype.Component;

@Component
public class AsignaturaMapper {

    public Asignatura toEntity(AsignaturaRequestDTO dto, Programa programa) {
        return Asignatura.builder()
                .codigo(dto.getCodigo())
                .nombre(dto.getNombre())
                .creditos(dto.getCreditos())
                .semestreSugerido(dto.getSemestreSugerido())
                .programa(programa)
                .build();
    }

    public AsignaturaResponseDTO toResponseDTO(Asignatura asignatura) {
        return AsignaturaResponseDTO.builder()
                .id(asignatura.getId())
                .codigo(asignatura.getCodigo())
                .nombre(asignatura.getNombre())
                .creditos(asignatura.getCreditos())
                .semestreSugerido(asignatura.getSemestreSugerido())
                .programa(asignatura.getPrograma() != null ? asignatura.getPrograma().getNombre() : "Sin programa")
                .build();
    }
}
