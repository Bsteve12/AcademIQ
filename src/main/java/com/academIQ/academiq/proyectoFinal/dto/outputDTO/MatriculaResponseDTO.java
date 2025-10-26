package com.academIQ.academiq.proyectoFinal.dto.outputDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Datos devueltos al consultar una matrícula")
public class MatriculaResponseDTO {

    @Schema(description = "ID de la matrícula", example = "10")
    private Long id;

    @Schema(description = "Nombre completo del estudiante", example = "Laura Gómez")
    private String estudiante;

    @Schema(description = "Asignatura matriculada", example = "Bases de Datos II")
    private String asignatura;

    @Schema(description = "Periodo académico", example = "2025-1")
    private String periodo;

    @Schema(description = "Estado actual de la matrícula", example = "Activa")
    private String estado;
}
