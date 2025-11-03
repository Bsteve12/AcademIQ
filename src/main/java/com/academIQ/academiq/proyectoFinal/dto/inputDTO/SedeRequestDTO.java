package com.academIQ.academiq.proyectoFinal.dto.inputDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Datos de entrada para crear o actualizar una sede")
public class SedeRequestDTO {

    @NotBlank
    @Schema(description = "Nombre de la sede", example = "Sede Central")
    private String nombre;

    @Schema(description = "Dirección de la sede", example = "Av. Universitaria #45-67")
    private String direccion;

    @Schema(description = "Ciudad donde se encuentra la sede", example = "Armenia")
    private String ciudad;
}
