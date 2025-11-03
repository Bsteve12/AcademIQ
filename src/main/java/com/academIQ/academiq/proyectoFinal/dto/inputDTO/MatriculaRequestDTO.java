package com.academIQ.academiq.proyectoFinal.dto.inputDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Datos de entrada para crear una matrícula")
public class MatriculaRequestDTO {

    @NotNull
    @Schema(description = "ID del estudiante", example = "5")
    private Long estudianteId;

    @NotNull
    @Schema(description = "ID de la asignatura", example = "3")
    private Long asignaturaId;

    @NotNull
    @Schema(description = "ID del periodo", example = "1")
    private Long periodoId;

    @NotBlank
    @Schema(description = "Estado inicial de la matrícula", example = "Activa")
    private String estado;
}
