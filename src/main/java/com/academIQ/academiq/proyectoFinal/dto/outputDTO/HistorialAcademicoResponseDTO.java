package com.academIQ.academiq.proyectoFinal.dto.outputDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Respuesta con los datos del historial académico de un estudiante")
public class HistorialAcademicoResponseDTO {

    @Schema(description = "ID del registro de historial académico", example = "101")
    private Long id;

    @Schema(description = "Nombre del estudiante", example = "Juan Pérez")
    private String estudianteNombre;

    @Schema(description = "Nombre de la asignatura", example = "Base de Datos II")
    private String asignaturaNombre;

    @Schema(description = "Nombre del periodo académico", example = "2025-1")
    private String periodoNombre;

    @Schema(description = "Nota final del estudiante", example = "4.0")
    private Double notaFinal;

    @Schema(description = "Resultado final", example = "APROBADO")
    private String resultado;

    @Schema(description = "Número de intento de la asignatura", example = "1")
    private Integer intentoNumero;

    @Schema(description = "Fecha de registro", example = "2025-10-25")
    private LocalDate fechaRegistro;
}
