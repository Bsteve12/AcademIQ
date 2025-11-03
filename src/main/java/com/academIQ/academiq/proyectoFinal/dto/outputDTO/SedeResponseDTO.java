package com.academIQ.academiq.proyectoFinal.dto.outputDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Datos de salida para mostrar información de una sede")
public class SedeResponseDTO {

    @Schema(description = "ID único de la sede", example = "1")
    private Long id;

    @Schema(description = "Nombre de la sede", example = "Sede Central")
    private String nombre;

    @Schema(description = "Dirección de la sede", example = "Av. Universitaria #45-67")
    private String direccion;

    @Schema(description = "Ciudad donde se encuentra la sede", example = "Armenia")
    private String ciudad;
}
