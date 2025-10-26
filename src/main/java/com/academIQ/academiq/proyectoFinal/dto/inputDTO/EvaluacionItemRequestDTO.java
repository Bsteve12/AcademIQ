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

    @NotNull
    @Schema(description = "ID de la asignatura a la que pertenece el ítem", example = "12")
    private Long asignaturaId;

    @NotBlank
    @Schema(description = "Nombre del ítem de evaluación", example = "Parcial 1")
    private String nombreItem;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    @DecimalMax(value = "100.0", inclusive = true)
    @Schema(description = "Porcentaje que aporta este ítem a la nota final (0 - 100)", example = "30.0")
    private Double porcentaje;

    @Schema(description = "Fecha de registro del ítem", example = "2025-03-10")
    private LocalDate fechaRegistro;
}
