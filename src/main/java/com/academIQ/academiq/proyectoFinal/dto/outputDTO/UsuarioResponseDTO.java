package com.academIQ.academiq.proyectoFinal.dto.outputDTO;

import com.academIQ.academiq.proyectoFinal.entity.enums.Rol;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Datos de salida para mostrar la información de un usuario")
public class UsuarioResponseDTO {

    @Schema(description = "ID del usuario", example = "5")
    private Long id;

    @Schema(description = "Nombre de usuario", example = "bceballos")
    private String username;

    @Schema(description = "Nombre completo del usuario", example = "Brandon Ceballos")
    private String nombreCompleto;

    @Schema(description = "Correo del usuario", example = "brandon@academiq.edu.co")
    private String correo;

    @Schema(description = "Rol asignado al usuario", example = "ADMIN")
    private Rol rol;

    @Schema(description = "Indica si el usuario está activo", example = "true")
    private boolean activo;
}
