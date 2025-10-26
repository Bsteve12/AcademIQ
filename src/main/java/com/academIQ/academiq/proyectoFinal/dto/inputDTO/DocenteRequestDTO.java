package com.academIQ.academiq.proyectoFinal.dto.inputDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Datos de entrada para crear o actualizar un docente")
public class DocenteRequestDTO {

    @NotBlank
    @Schema(description = "Nombre completo del docente", example = "María Gómez")
    private String nombre;

    @NotBlank
    @Email
    @Schema(description = "Correo institucional del docente", example = "maria.gomez@universidad.edu")
    private String correo;

    @Schema(description = "Teléfono del docente", example = "+57 3120000000")
    private String telefono;

    @Schema(description = "Especialidad del docente", example = "Algoritmos")
    private String especialidad;

    @Schema(description = "Lista de IDs de asignaturas que dicta el docente", example = "[1, 2, 3]")
    private List<Long> asignaturaIds;
}
