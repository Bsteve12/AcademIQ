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

    @Schema(description = "ID del ítem", example = "5")
    private Long id;

    @Schema(description = "Nombre del ítem", example = "Parcial 1")
    private String nombreItem;

    @Schema(description = "Porcentaje del ítem", example = "30.0")
    private Double porcentaje;

    @Schema(description = "Fecha de registro", example = "2025-03-10")
    private LocalDate fechaRegistro;

    @Schema(description = "ID de la asignatura asociada", example = "12")
    private Long asignaturaId;

    @Schema(description = "Nombre de la asignatura asociada", example = "Bases de Datos II")
    private String asignaturaNombre;
}
