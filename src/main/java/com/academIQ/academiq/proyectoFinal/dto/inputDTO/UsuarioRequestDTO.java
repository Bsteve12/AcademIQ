package com.academIQ.academiq.proyectoFinal.dto.inputDTO;

import com.academIQ.academiq.proyectoFinal.entity.enums.Rol;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Datos de entrada para registrar o actualizar un usuario del sistema")
public class UsuarioRequestDTO {

    @NotBlank
    @Schema(description = "Nombre de usuario único para iniciar sesión", example = "bceballos")
    private String username;

    @NotBlank
    @Schema(description = "Contraseña del usuario (se encriptará antes de guardarse)", example = "1234Segura!")
    private String password;

    @NotBlank
    @Schema(description = "Nombre completo del usuario", example = "Brandon Stiven Ceballos Delgado")
    private String nombreCompleto;

    @Email
    @Schema(description = "Correo electrónico del usuario", example = "brandon@academiq.edu.co")
    private String correo;

    @NotNull
    @Schema(description = "Rol asignado al usuario", example = "ADMIN")
    private Rol rol;
}
