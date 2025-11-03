package com.academIQ.academiq.proyectoFinal.mapper;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.IntentoMatriculaRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.IntentoMatriculaResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.*;
import org.springframework.stereotype.Component;

@Component
public class IntentoMatriculaMapper {

    public IntentoMatricula toEntity(IntentoMatriculaRequestDTO dto,
                                     Estudiante estudiante,
                                     Grupo grupo) {
        return IntentoMatricula.builder()
                .estudiante(estudiante)
                .grupo(grupo)
                .motivo(dto.getMotivo())
                .fechaIntento(dto.getFechaIntento())
                .exitoso(dto.isExitoso())
                .build();
    }

    public IntentoMatriculaResponseDTO toResponseDTO(IntentoMatricula entity) {
        return IntentoMatriculaResponseDTO.builder()
                .id(entity.getId())
                .estudianteNombre(entity.getEstudiante().getNombre() + " " + entity.getEstudiante().getApellido())
                .grupoCodigo(entity.getGrupo().getCodigoGrupo())
                .motivo(entity.getMotivo())
                .fechaIntento(entity.getFechaIntento())
                .exitoso(entity.isExitoso())
                .build();
    }
}
