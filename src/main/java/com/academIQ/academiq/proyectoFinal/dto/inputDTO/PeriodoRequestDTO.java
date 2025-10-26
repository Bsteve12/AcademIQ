package com.academIQ.academiq.proyectoFinal.dto.inputDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Datos de entrada para crear o actualizar un periodo académico")
public class PeriodoRequestDTO {

    @NotBlank
    @Schema(description = "Nombre del periodo académico", example = "2025-1")
    private String nombre;

    @NotNull
    @Schema(description = "Fecha de inicio del periodo", example = "2025-02-01")
    private LocalDate fechaInicio;

    @NotNull
    @Schema(description = "Fecha de fin del periodo", example = "2025-06-30")
    private LocalDate fechaFin;

    @Schema(description = "Indica si el periodo está activo", example = "true")
    private boolean activo;
}
