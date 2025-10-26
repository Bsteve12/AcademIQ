package com.academIQ.academiq.proyectoFinal.dto.inputDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Datos de entrada para crear o actualizar un grupo académico")
public class GrupoRequestDTO {

    @NotBlank
    @Schema(description = "Código único del grupo", example = "GRP-2025-01")
    private String codigoGrupo;

    @NotNull
    @Schema(description = "ID de la asignatura a la que pertenece el grupo", example = "10")
    private Long asignaturaId;

    @NotNull
    @Schema(description = "ID del docente asignado al grupo", example = "7")
    private Long docenteId;

    @NotNull
    @Schema(description = "ID del periodo académico", example = "3")
    private Long periodoId;

    @Schema(description = "ID del salón donde se dicta la clase", example = "5")
    private Long salonId;

    @NotNull
    @Schema(description = "Número máximo de estudiantes permitidos", example = "35")
    private Integer cupoMaximo;
}
