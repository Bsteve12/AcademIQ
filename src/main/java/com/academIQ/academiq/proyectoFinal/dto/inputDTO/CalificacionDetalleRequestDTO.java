package com.academIQ.academiq.proyectoFinal.dto.inputDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Datos de entrada para crear o actualizar un detalle de calificación")
public class CalificacionDetalleRequestDTO {

    @NotNull
    @Schema(description = "ID del ítem de evaluación (EvaluacionItem)", example = "7")
    private Long evaluacionItemId;

    @NotNull
    @Schema(description = "ID de la calificación padre", example = "45")
    private Long calificacionId;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "5.0", inclusive = true)
    @Schema(description = "Nota obtenida para este ítem (0.0 - 5.0)", example = "4.25")
    private Double nota;
}
