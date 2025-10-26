package com.academIQ.academiq.proyectoFinal.mapper;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.EstudianteRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.EstudianteResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.Estudiante;
import com.academIQ.academiq.proyectoFinal.entity.Programa;
import org.springframework.stereotype.Component;

@Component
public class EstudianteMapper {

    /**
     * Convierte un RequestDTO a la entidad Estudiante.
     * Nota: el Programa debe resolverse desde el servicio (repository) y pasarse aquí.
     */
    public Estudiante toEntity(EstudianteRequestDTO dto, Programa programa) {
        return Estudiante.builder()
                .codigo(dto.getCodigo())
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .correo(dto.getCorreo())
                .telefono(dto.getTelefono())
                .promedioGeneral(dto.getPromedioGeneral())
                .nivelRiesgo(dto.getNivelRiesgo())
                .programa(programa)
                .build();
    }

    /**
     * Convierte la entidad Estudiante a ResponseDTO.
     */
    public EstudianteResponseDTO toResponseDTO(Estudiante estudiante) {
        return EstudianteResponseDTO.builder()
                .id(estudiante.getId())
                .codigo(estudiante.getCodigo())
                .nombreCompleto(estudiante.getNombre() + " " + estudiante.getApellido())
                .correo(estudiante.getCorreo())
                .telefono(estudiante.getTelefono())
                .programa(estudiante.getPrograma() != null ? estudiante.getPrograma().getNombre() : "Sin programa")
                .promedioGeneral(estudiante.getPromedioGeneral())
                .nivelRiesgo(estudiante.getNivelRiesgo())
                .build();
    }
}
