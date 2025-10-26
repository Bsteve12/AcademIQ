package com.academIQ.academiq.proyectoFinal.dto.outputDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Respuesta con la información de un intento de matrícula")
public class IntentoMatriculaResponseDTO {

    @Schema(description = "ID del intento de matrícula", example = "101")
    private Long id;

    @Schema(description = "Nombre del estudiante", example = "Juan Pérez")
    private String estudianteNombre;

    @Schema(description = "Código del grupo", example = "BD2-G1")
    private String grupoCodigo;

    @Schema(description = "Motivo del intento", example = "CHOQUE")
    private String motivo;

    @Schema(description = "Fecha y hora del intento", example = "2025-10-25T09:30:00")
    private LocalDateTime fechaIntento;

    @Schema(description = "Resultado del intento (true = exitoso, false = fallido)", example = "false")
    private boolean exitoso;
}
