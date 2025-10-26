package com.academIQ.academiq.proyectoFinal.dto.outputDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Datos devueltos para un estudiante")
public class EstudianteResponseDTO {

    @Schema(description = "ID interno del estudiante", example = "15")
    private Long id;

    @Schema(description = "Código único del estudiante", example = "20251234")
    private String codigo;

    @Schema(description = "Nombre completo del estudiante", example = "Juan Pérez")
    private String nombreCompleto;

    @Schema(description = "Correo electrónico del estudiante", example = "juan.perez@universidad.edu")
    private String correo;

    @Schema(description = "Teléfono del estudiante", example = "+57 3001234567")
    private String telefono;

    @Schema(description = "Nombre del programa al que pertenece el estudiante", example = "Ingeniería de Sistemas")
    private String programa;

    @Schema(description = "Promedio general", example = "3.45")
    private Double promedioGeneral;

    @Schema(description = "Nivel de riesgo académico", example = "Medio")
    private String nivelRiesgo;
}
