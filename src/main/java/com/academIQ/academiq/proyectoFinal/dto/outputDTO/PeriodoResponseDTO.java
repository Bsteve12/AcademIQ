package com.academIQ.academiq.proyectoFinal.dto.outputDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Datos de salida que representan un periodo académico")
public class PeriodoResponseDTO {

    @Schema(description = "ID del periodo", example = "1")
    private Long id;

    @Schema(description = "Nombre del periodo", example = "2025-1")
    private String nombre;

    @Schema(description = "Fecha de inicio", example = "2025-02-01")
    private LocalDate fechaInicio;

    @Schema(description = "Fecha de fin", example = "2025-06-30")
    private LocalDate fechaFin;

    @Schema(description = "Indica si el periodo está activo", example = "true")
    private boolean activo;
}
