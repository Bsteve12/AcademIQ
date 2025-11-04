// src/app/models/usuario-request.interface.ts (Ruta sugerida)

import { Rol } from '../enums/Role';

/**
 * DTO de Petición de Usuario para Angular.
 * Corresponde a UsuarioRequestDTO en el backend.
 */
export interface UserRequest {
  /**
   * Nombre de usuario único para iniciar sesión.
   * @example "bceballos"
   */
  username: string; // @NotBlank

  /**
   * Contraseña del usuario (se enviará para ser encriptada).
   * @example "1234Segura!"
   */
  password: string; // @NotBlank

  /**
   * Nombre completo del usuario.
   * @example "Brandon Stiven Ceballos Delgado"
   */
  nombreCompleto: string; // @NotBlank

  /**
   * Correo electrónico del usuario.
   * @example "brandon@academiq.edu.co"
   */
  correo: string; // @Email

  /**
   * Rol asignado al usuario, usando nuestro enum de TypeScript.
   * @example Rol.ADMIN
   */
  rol: Rol; // @NotNull
}