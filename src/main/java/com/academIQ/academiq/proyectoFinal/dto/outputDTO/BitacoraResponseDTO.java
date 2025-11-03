package com.academIQ.academiq.proyectoFinal.dto.outputDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Respuesta con los datos registrados en la bitácora del sistema")
public class BitacoraResponseDTO {

    @Schema(description = "ID del registro de bitácora", example = "15")
    private Long id;

    @Schema(description = "Acción registrada", example = "CREAR_MATRICULA")
    private String accion;

    @Schema(description = "Entidad afectada", example = "Matricula")
    private String entidad;

    @Schema(description = "ID de la entidad afectada", example = "10")
    private Long entidadId;

    @Schema(description = "Detalle adicional de la acción")
    private String detalle;

    @Schema(description = "Dirección IP desde la cual se realizó la acción", example = "192.168.1.15")
    private String ip;

    @Schema(description = "Fecha y hora del registro en la bitácora", example = "2025-10-25T19:42:00")
    private LocalDateTime fechaHora;

    @Schema(description = "Nombre del usuario que ejecutó la acción", example = "Brandon Ceballos")
    private String usuarioNombre;
}
