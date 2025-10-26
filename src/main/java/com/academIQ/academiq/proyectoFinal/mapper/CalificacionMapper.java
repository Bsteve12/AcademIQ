package com.academIQ.academiq.proyectoFinal.mapper;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.CalificacionRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.CalificacionResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.Calificacion;
import com.academIQ.academiq.proyectoFinal.entity.Matricula;
import org.springframework.stereotype.Component;

@Component
public class CalificacionMapper {

    public Calificacion toEntity(CalificacionRequestDTO dto, Matricula matricula) {
        return Calificacion.builder()
                .nota1(dto.getNota1())
                .nota2(dto.getNota2())
                .nota3(dto.getNota3())
                .matricula(matricula)
                .build();
    }

    public CalificacionResponseDTO toResponseDTO(Calificacion entity) {
        return CalificacionResponseDTO.builder()
                .id(entity.getId())
                .matriculaId(entity.getMatricula().getId())
                .nota1(entity.getNota1())
                .nota2(entity.getNota2())
                .nota3(entity.getNota3())
                .notaFinal(entity.getNotaFinal())
                .build();
    }
}
