package com.academIQ.academiq.proyectoFinal.dto.inputDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Datos de entrada para crear o actualizar un ítem de evaluación")
public class EvaluacionItemRequestDTO {

    @NotBlank
    @Schema(description = "Nombre del ítem de evaluación", example = "Parcial 1")
    private String nombreItem;

    @Schema(description = "Descripción del ítem de evaluación", example = "Evaluación escrita sobre los temas vistos en el primer corte")
    private String descripcion;

    @NotNull
    @DecimalMin(value = "0.0")
    @DecimalMax(value = "100.0")
    @Schema(description = "Porcentaje que representa dentro de la calificación final", example = "30.0")
    private Double porcentaje;

    @Schema(description = "Fecha de registro del ítem de evaluación", example = "2025-10-25")
    private LocalDate fechaRegistro;

    @NotNull
    @Schema(description = "ID de la asignatura asociada", example = "5")
    private Long asignaturaId;
}
