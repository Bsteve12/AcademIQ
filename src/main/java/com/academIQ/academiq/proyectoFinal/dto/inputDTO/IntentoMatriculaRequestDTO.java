package com.academIQ.academiq.proyectoFinal.dto.inputDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Datos de entrada para registrar un intento de matrícula")
public class IntentoMatriculaRequestDTO {

    @NotNull
    @Schema(description = "ID del estudiante que intenta matricularse", example = "5")
    private Long estudianteId;

    @NotNull
    @Schema(description = "ID del grupo al que intenta matricularse", example = "12")
    private Long grupoId;

    @Schema(description = "Motivo del intento fallido o exitoso", example = "CUPO")
    private String motivo;

    @Schema(description = "Fecha y hora del intento", example = "2025-10-25T09:30:00")
    private LocalDateTime fechaIntento;

    @Schema(description = "Indica si el intento fue exitoso", example = "true")
    private boolean exitoso;
}
