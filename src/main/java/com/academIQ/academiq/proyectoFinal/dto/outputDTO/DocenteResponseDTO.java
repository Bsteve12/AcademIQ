package com.academIQ.academiq.proyectoFinal.dto.outputDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Datos devueltos para un docente")
public class DocenteResponseDTO {

    @Schema(description = "ID del docente", example = "12")
    private Long id;

    @Schema(description = "Nombre del docente", example = "María Gómez")
    private String nombre;

    @Schema(description = "Correo del docente", example = "maria.gomez@universidad.edu")
    private String correo;

    @Schema(description = "Teléfono", example = "+57 3120000000")
    private String telefono;

    @Schema(description = "Especialidad", example = "Algoritmos")
    private String especialidad;

    @Schema(description = "Lista de códigos o nombres de asignaturas que dicta")
    private List<String> asignaturas;
}
