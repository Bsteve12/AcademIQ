package com.academIQ.academiq.proyectoFinal.dto.inputDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Datos de entrada para registrar o actualizar una calificación")
public class CalificacionRequestDTO {

    @NotNull
    @Schema(description = "ID de la matrícula asociada", example = "12")
    private Long matriculaId;

    @Min(0)
    @Max(5)
    @Schema(description = "Nota del primer parcial", example = "3.5")
    private Double nota1;

    @Min(0)
    @Max(5)
    @Schema(description = "Nota del segundo parcial", example = "4.0")
    private Double nota2;

    @Min(0)
    @Max(5)
    @Schema(description = "Nota del tercer parcial", example = "4.8")
    private Double nota3;
}
