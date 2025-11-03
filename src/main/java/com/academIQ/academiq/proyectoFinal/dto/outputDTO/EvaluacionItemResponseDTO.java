package com.academIQ.academiq.proyectoFinal.dto.outputDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Respuesta con los datos de un ítem de evaluación")
public class EvaluacionItemResponseDTO {

    @Schema(description = "ID del ítem de evaluación", example = "12")
    private Long id;

    @Schema(description = "Nombre del ítem de evaluación", example = "Parcial 1")
    private String nombreItem;

    @Schema(description = "Descripción del ítem de evaluación", example = "Evaluación escrita sobre los temas vistos en el primer corte")
    private String descripcion;

    @Schema(description = "Porcentaje que aporta a la nota final", example = "30.0")
    private Double porcentaje;

    @Schema(description = "Fecha de registro del ítem", example = "2025-10-25")
    private LocalDate fechaRegistro;

    @Schema(description = "Nombre de la asignatura asociada", example = "Bases de Datos II")
    private String asignaturaNombre;
}
