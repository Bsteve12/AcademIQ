package com.academIQ.academiq.proyectoFinal.dto.inputDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Datos de entrada para registrar un prerrequisito de una asignatura")
public class PrerrequisitoRequestDTO {

    @NotNull
    @Schema(description = "ID de la asignatura principal", example = "5")
    private Long asignaturaId;

    @NotNull
    @Schema(description = "ID de la asignatura que actúa como prerrequisito", example = "2")
    private Long prerrequisitoId;
}
