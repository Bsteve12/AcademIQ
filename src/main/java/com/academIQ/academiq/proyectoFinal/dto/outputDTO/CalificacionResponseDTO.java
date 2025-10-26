package com.academIQ.academiq.proyectoFinal.dto.outputDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Respuesta con los datos de una calificación registrada")
public class CalificacionResponseDTO {

    @Schema(description = "ID de la calificación", example = "45")
    private Long id;

    @Schema(description = "ID de la matrícula asociada", example = "12")
    private Long matriculaId;

    @Schema(description = "Nota 1 del estudiante", example = "3.5")
    private Double nota1;

    @Schema(description = "Nota 2 del estudiante", example = "4.0")
    private Double nota2;

    @Schema(description = "Nota 3 del estudiante", example = "4.8")
    private Double nota3;

    @Schema(description = "Nota final (promedio ponderado o automática en Oracle)", example = "4.1")
    private Double notaFinal;
}
