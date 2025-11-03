package com.academIQ.academiq.proyectoFinal.mapper;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.PrerrequisitoRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.PrerrequisitoResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.Asignatura;
import com.academIQ.academiq.proyectoFinal.entity.Prerrequisito;
import org.springframework.stereotype.Component;

@Component
public class PrerrequisitoMapper {

    public Prerrequisito toEntity(PrerrequisitoRequestDTO dto, Asignatura asignatura, Asignatura prerrequisito) {
        return Prerrequisito.builder()
                .asignatura(asignatura)
                .prerrequisito(prerrequisito)
                .build();
    }

    public PrerrequisitoResponseDTO toResponseDTO(Prerrequisito entity) {
        return PrerrequisitoResponseDTO.builder()
                .id(entity.getId())
                .asignaturaNombre(entity.getAsignatura() != null ? entity.getAsignatura().getNombre() : "Desconocida")
                .prerrequisitoNombre(entity.getPrerrequisito() != null ? entity.getPrerrequisito().getNombre() : "Desconocido")
                .build();
    }
}
