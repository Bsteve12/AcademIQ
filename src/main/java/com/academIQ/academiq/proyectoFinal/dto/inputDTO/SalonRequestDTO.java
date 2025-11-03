package com.academIQ.academiq.proyectoFinal.dto.inputDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Datos de entrada para crear o actualizar un salón")
public class SalonRequestDTO {

    @NotBlank
    @Schema(description = "Nombre del salón", example = "Lab. Sistemas 201")
    private String nombre;

    @Schema(description = "Ubicación o edificio", example = "Bloque A - Piso 2")
    private String ubicacion;

    @NotNull
    @Min(1)
    @Schema(description = "Capacidad máxima (número de personas)", example = "40")
    private Integer capacidad;

    @NotNull
    @Schema(description = "ID de la sede a la que pertenece el salón", example = "1")
    private Long sedeId;
}
