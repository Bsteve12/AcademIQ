package com.academIQ.academiq.proyectoFinal.dto.outputDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Datos devueltos de un programa académico")
public class ProgramaResponseDTO {

    @Schema(description = "ID del programa", example = "5")
    private Long id;

    @Schema(description = "Nombre del programa", example = "Ingeniería de Sistemas")
    private String nombre;

    @Schema(description = "Facultad del programa", example = "Facultad de Ingeniería")
    private String facultad;

    @Schema(description = "Duración en semestres", example = "10")
    private Integer duracionSemestres;

    @Schema(description = "Nombre de la sede asociada", example = "Sede Bogotá")
    private String sede;

    @Schema(description = "Cantidad aproximada de estudiantes (opcional)", example = "120")
    private Integer estudiantesCount;
}
