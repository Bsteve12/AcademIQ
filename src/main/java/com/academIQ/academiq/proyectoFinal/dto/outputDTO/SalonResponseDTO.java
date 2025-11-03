package com.academIQ.academiq.proyectoFinal.dto.outputDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Datos devueltos con la información de un salón")
public class SalonResponseDTO {

    @Schema(description = "ID del salón", example = "3")
    private Long id;

    @Schema(description = "Nombre del salón", example = "Lab. Sistemas 201")
    private String nombre;

    @Schema(description = "Ubicación o edificio", example = "Bloque A - Piso 2")
    private String ubicacion;

    @Schema(description = "Capacidad máxima", example = "40")
    private Integer capacidad;

    @Schema(description = "Nombre de la sede a la que pertenece", example = "Sede Central")
    private String sede;
}
