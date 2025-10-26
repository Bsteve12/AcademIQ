package com.academIQ.academiq.proyectoFinal.dto.inputDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Datos de entrada para crear o actualizar un programa académico")
public class ProgramaRequestDTO {

    @NotBlank
    @Schema(description = "Nombre único del programa", example = "Ingeniería de Sistemas")
    private String nombre;

    @NotBlank
    @Schema(description = "Facultad a la que pertenece el programa", example = "Facultad de Ingeniería")
    private String facultad;

    @NotNull
    @Schema(description = "Duración en semestres del programa", example = "10")
    private Integer duracionSemestres;

    @NotNull
    @Schema(description = "ID de la sede a la que pertenece el programa", example = "1")
    private Long sedeId;
}
