package com.academIQ.academiq.proyectoFinal.mapper;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.DocenteRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.DocenteResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.Asignatura;
import com.academIQ.academiq.proyectoFinal.entity.Docente;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DocenteMapper {

    /**
     * Convierte RequestDTO -> Entity. Las asignaturas deben resolverse y pasarse aquí.
     */
    public Docente toEntity(DocenteRequestDTO dto, List<Asignatura> asignaturas) {
        return Docente.builder()
                .nombre(dto.getNombre())
                .correo(dto.getCorreo())
                .telefono(dto.getTelefono())
                .especialidad(dto.getEspecialidad())
                .asignaturas(asignaturas)
                .build();
    }

    /**
     * Convierte Entity -> ResponseDTO.
     */
    public DocenteResponseDTO toResponseDTO(Docente docente) {
        List<String> asignaturas = null;
        if (docente.getAsignaturas() != null) {
            asignaturas = docente.getAsignaturas()
                    .stream()
                    .map(a -> a.getCodigo() + " - " + a.getNombre())
                    .collect(Collectors.toList());
        }
        return DocenteResponseDTO.builder()
                .id(docente.getId())
                .nombre(docente.getNombre())
                .correo(docente.getCorreo())
                .telefono(docente.getTelefono())
                .especialidad(docente.getEspecialidad())
                .asignaturas(asignaturas)
                .build();
    }
}
