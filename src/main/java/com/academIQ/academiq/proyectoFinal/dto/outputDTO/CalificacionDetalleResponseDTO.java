package com.academIQ.academiq.proyectoFinal.dto.outputDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Respuesta con los datos de un detalle de calificación")
public class CalificacionDetalleResponseDTO {

    @Schema(description = "ID del detalle", example = "101")
    private Long id;

    @Schema(description = "ID del ítem de evaluación", example = "7")
    private Long evaluacionItemId;

    @Schema(description = "Nombre o descripción del ítem de evaluación", example = "Parcial 1 - Teoría")
    private String evaluacionItemDescripcion;

    @Schema(description = "ID de la calificación padre", example = "45")
    private Long calificacionId;

    @Schema(description = "Nota registrada para el ítem", example = "4.25")
    private Double nota;
}
