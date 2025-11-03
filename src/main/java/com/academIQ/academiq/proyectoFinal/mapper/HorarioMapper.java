package com.academIQ.academiq.proyectoFinal.mapper;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.HorarioRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.HorarioResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.Grupo;
import com.academIQ.academiq.proyectoFinal.entity.Horario;
import org.springframework.stereotype.Component;

@Component
public class HorarioMapper {

    public Horario toEntity(HorarioRequestDTO dto, Grupo grupo) {
        return Horario.builder()
                .diaSemana(dto.getDiaSemana())
                .horaInicio(dto.getHoraInicio())
                .horaFin(dto.getHoraFin())
                .grupo(grupo)
                .build();
    }

    public HorarioResponseDTO toResponseDTO(Horario entity) {
        return HorarioResponseDTO.builder()
                .id(entity.getId())
                .diaSemana(entity.getDiaSemana())
                .horaInicio(entity.getHoraInicio())
                .horaFin(entity.getHoraFin())
                .grupoCodigo(entity.getGrupo() != null ? entity.getGrupo().getCodigoGrupo() : "Sin grupo")
                .build();
    }
}
