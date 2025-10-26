package com.academIQ.academiq.proyectoFinal.mapper;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.HistorialAcademicoRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.HistorialAcademicoResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.Asignatura;
import com.academIQ.academiq.proyectoFinal.entity.Estudiante;
import com.academIQ.academiq.proyectoFinal.entity.HistorialAcademico;
import com.academIQ.academiq.proyectoFinal.entity.Periodo;
import org.springframework.stereotype.Component;

@Component
public class HistorialAcademicoMapper {

    public HistorialAcademico toEntity(HistorialAcademicoRequestDTO dto,
                                       Estudiante estudiante,
                                       Asignatura asignatura,
                                       Periodo periodo) {
        return HistorialAcademico.builder()
                .estudiante(estudiante)
                .asignatura(asignatura)
                .periodo(periodo)
                .notaFinal(dto.getNotaFinal())
                .resultado(dto.getResultado())
                .intentoNumero(dto.getIntentoNumero())
                .fechaRegistro(dto.getFechaRegistro())
                .build();
    }

    public HistorialAcademicoResponseDTO toResponseDTO(HistorialAcademico entity) {
        return HistorialAcademicoResponseDTO.builder()
                .id(entity.getId())
                .estudianteNombre(entity.getEstudiante().getNombre() + " " + entity.getEstudiante().getApellido())
                .asignaturaNombre(entity.getAsignatura().getNombre())
                .periodoNombre(entity.getPeriodo().getNombre())
                .notaFinal(entity.getNotaFinal())
                .resultado(entity.getResultado())
                .intentoNumero(entity.getIntentoNumero())
                .fechaRegistro(entity.getFechaRegistro())
                .build();
    }
}
