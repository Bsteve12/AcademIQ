package com.academIQ.academiq.proyectoFinal.dto.inputDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Datos de entrada para crear o actualizar un estudiante")
public class EstudianteRequestDTO {

    @NotBlank
    @Schema(description = "Código único del estudiante", example = "20251234")
    private String codigo;

    @NotBlank
    @Schema(description = "Nombre del estudiante", example = "Juan")
    private String nombre;

    @NotBlank
    @Schema(description = "Apellido del estudiante", example = "Pérez")
    private String apellido;

    @NotBlank
    @Email
    @Schema(description = "Correo electrónico del estudiante", example = "juan.perez@universidad.edu")
    private String correo;

    @Schema(description = "Teléfono del estudiante", example = "+57 3001234567")
    private String telefono;

    @NotNull
    @Schema(description = "ID del programa al que pertenece el estudiante", example = "2")
    private Long programaId;

    @Schema(description = "Promedio general del estudiante", example = "3.45")
    private Double promedioGeneral;

    @Schema(description = "Nivel de riesgo académico (Bajo, Medio, Alto)", example = "Medio")
    private String nivelRiesgo;
}
