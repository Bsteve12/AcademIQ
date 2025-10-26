package com.academIQ.academiq.proyectoFinal.mapper;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.GrupoRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.GrupoResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.*;
import org.springframework.stereotype.Component;

@Component
public class GrupoMapper {

    public Grupo toEntity(GrupoRequestDTO dto, Asignatura asignatura, Docente docente, Periodo periodo, Salon salon) {
        return Grupo.builder()
                .codigoGrupo(dto.getCodigoGrupo())
                .asignatura(asignatura)
                .docente(docente)
                .periodo(periodo)
                .salon(salon)
                .cupoMaximo(dto.getCupoMaximo())
                .cupoActual(0) // Se inicia en 0, el control real se lleva en Oracle
                .build();
    }

    public GrupoResponseDTO toResponseDTO(Grupo grupo) {
        return GrupoResponseDTO.builder()
                .id(grupo.getId())
                .codigoGrupo(grupo.getCodigoGrupo())
                .asignatura(grupo.getAsignatura() != null ? grupo.getAsignatura().getNombre() : "No asignada")
                .docente(grupo.getDocente() != null ? grupo.getDocente().getNombre() : "Sin docente")
                .salon(grupo.getSalon() != null ? grupo.getSalon().getNombre() : "Sin salón")
                .periodo(grupo.getPeriodo() != null ? grupo.getPeriodo().getNombre() : "Sin periodo")
                .cupoMaximo(grupo.getCupoMaximo())
                .cupoActual(grupo.getCupoActual())
                .build();
    }
}
