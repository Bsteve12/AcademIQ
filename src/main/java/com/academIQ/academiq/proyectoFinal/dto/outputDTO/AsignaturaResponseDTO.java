package com.academIQ.academiq.proyectoFinal.dto.outputDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Datos de salida con la información de una asignatura")
public class AsignaturaResponseDTO {

    @Schema(description = "ID único de la asignatura", example = "5")
    private Long id;

    @Schema(description = "Código de la asignatura", example = "INF-101")
    private String codigo;

    @Schema(description = "Nombre de la asignatura", example = "Programación I")
    private String nombre;

    @Schema(description = "Número de créditos", example = "3")
    private Integer creditos;

    @Schema(description = "Semestre sugerido", example = "1")
    private Integer semestreSugerido;

    @Schema(description = "Nombre del programa académico al que pertenece", example = "Ingeniería de Sistemas")
    private String programa;
}
