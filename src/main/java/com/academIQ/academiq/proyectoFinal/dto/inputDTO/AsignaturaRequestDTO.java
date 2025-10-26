package com.academIQ.academiq.proyectoFinal.dto.inputDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Datos de entrada para crear o actualizar una asignatura")
public class AsignaturaRequestDTO {

    @NotBlank
    @Schema(description = "Código único de la asignatura", example = "INF-101")
    private String codigo;

    @NotBlank
    @Schema(description = "Nombre de la asignatura", example = "Programación I")
    private String nombre;

    @NotNull
    @Min(1)
    @Max(10)
    @Schema(description = "Cantidad de créditos de la asignatura", example = "3")
    private Integer creditos;

    @Schema(description = "Semestre sugerido en el plan de estudios", example = "1")
    private Integer semestreSugerido;

    @NotNull
    @Schema(description = "ID del programa al que pertenece la asignatura", example = "2")
    private Long programaId;
}
