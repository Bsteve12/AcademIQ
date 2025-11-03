package com.academIQ.academiq.proyectoFinal.dto.outputDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Datos de salida que representan un grupo académico")
public class GrupoResponseDTO {

    @Schema(description = "ID del grupo", example = "1")
    private Long id;

    @Schema(description = "Código del grupo", example = "GRP-2025-01")
    private String codigoGrupo;

    @Schema(description = "Nombre de la asignatura", example = "Bases de Datos II")
    private String asignatura;

    @Schema(description = "Nombre del docente asignado", example = "Juan Pérez")
    private String docente;

    @Schema(description = "Nombre del salón", example = "Lab. Sistemas 201")
    private String salon;

    @Schema(description = "Periodo académico", example = "2025-1")
    private String periodo;

    @Schema(description = "Cupo máximo permitido", example = "35")
    private Integer cupoMaximo;

    @Schema(description = "Cupo actual ocupado", example = "22")
    private Integer cupoActual;
}
