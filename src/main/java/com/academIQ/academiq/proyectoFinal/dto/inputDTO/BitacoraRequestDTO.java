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
@Schema(description = "Datos de entrada para registrar una acción en la bitácora del sistema")
public class BitacoraRequestDTO {

    @NotNull
    @Schema(description = "ID del usuario que realizó la acción", example = "3")
    private Long usuarioId;

    @NotBlank
    @Schema(description = "Nombre de la acción realizada", example = "CREAR_MATRICULA")
    private String accion;

    @NotBlank
    @Schema(description = "Entidad sobre la cual se realizó la acción", example = "Matricula")
    private String entidad;

    @NotNull
    @Schema(description = "ID de la entidad afectada", example = "10")
    private Long entidadId;

    @Schema(description = "Detalle adicional de la acción", example = "El usuario registró la matrícula del estudiante con código 20251025")
    private String detalle;

    @Schema(description = "Dirección IP desde la cual se realizó la acción", example = "192.168.1.15")
    private String ip;
}
