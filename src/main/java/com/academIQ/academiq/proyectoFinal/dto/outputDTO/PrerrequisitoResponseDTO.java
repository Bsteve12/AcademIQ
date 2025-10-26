package com.academIQ.academiq.proyectoFinal.dto.outputDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Datos de salida para mostrar los prerrequisitos de una asignatura")
public class PrerrequisitoResponseDTO {

    @Schema(description = "ID del registro de prerrequisito", example = "10")
    private Long id;

    @Schema(description = "Nombre de la asignatura principal", example = "Programación II")
    private String asignaturaNombre;

    @Schema(description = "Nombre de la asignatura prerrequisito", example = "Programación I")
    private String prerrequisitoNombre;
}
