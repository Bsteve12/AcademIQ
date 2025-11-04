

import { Rol } from "../enums/Role";

/**
 * Modelo de datos para un Usuario.
 * Corresponde a UsuarioResponseDTO en el backend.
 */
export interface UserResponse {
  /**
   * ID del usuario (Clave primaria). Long de Java -> number de TypeScript.
   * @example 5
   */
  id: number;

  /**
   * Nombre de usuario (login).
   */
  username: string;

  /**
   * Nombre completo del usuario.
   */
  nombreCompleto: string;

  /**
   * Correo del usuario.
   */
  correo: string;

  /**
   * Rol asignado al usuario.
   * Mapea Rol (Enum de Java) a Role (Enum de TypeScript).
   * @example Role.ADMIN
   */
  rol: Rol;
  
  /**
   * Indica si el usuario está activo.
   * Mapea 'boolean' primitiva de Java a 'boolean' de TypeScript (siempre requerida).
   * @example true
   */
  activo: boolean;
}