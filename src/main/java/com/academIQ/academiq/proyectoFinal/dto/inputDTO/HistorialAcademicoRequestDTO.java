package com.academIQ.academiq.proyectoFinal.dto.inputDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Datos de entrada para registrar un historial académico")
public class HistorialAcademicoRequestDTO {

    @NotNull
    @Schema(description = "ID del estudiante", example = "5")
    private Long estudianteId;

    @NotNull
    @Schema(description = "ID de la asignatura", example = "12")
    private Long asignaturaId;

    @NotNull
    @Schema(description = "ID del periodo académico", example = "3")
    private Long periodoId;

    @Schema(description = "Nota final obtenida", example = "4.5")
    private Double notaFinal;

    @Schema(description = "Resultado final del estudiante en la materia", example = "APROBADO")
    private String resultado;

    @Schema(description = "Número de intento de la asignatura", example = "1")
    private Integer intentoNumero;

    @Schema(description = "Fecha de registro en el historial", example = "2025-10-25")
    private LocalDate fechaRegistro;
}
