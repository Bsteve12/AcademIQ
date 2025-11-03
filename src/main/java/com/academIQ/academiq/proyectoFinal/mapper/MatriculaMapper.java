package com.academIQ.academiq.proyectoFinal.mapper;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.MatriculaRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.MatriculaResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.*;

import org.springframework.stereotype.Component;

@Component
public class MatriculaMapper {

    public Matricula toEntity(MatriculaRequestDTO dto, Estudiante estudiante, Asignatura asignatura, Periodo periodo) {
        return Matricula.builder()
                .estudiante(estudiante)
                .asignatura(asignatura)
                .periodo(periodo)
                .estado(dto.getEstado())
                .build();
    }

    public MatriculaResponseDTO toResponseDTO(Matricula matricula) {
        return MatriculaResponseDTO.builder()
                .id(matricula.getId())
                .estudiante(matricula.getEstudiante().getNombre() + " " + matricula.getEstudiante().getApellido())
                .asignatura(matricula.getAsignatura().getNombre())
                .periodo(matricula.getPeriodo().getNombre())
                .estado(matricula.getEstado())
                .build();
    }
}
