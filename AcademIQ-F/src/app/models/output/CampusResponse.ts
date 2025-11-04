
/**
 * DTO de Petición para crear o actualizar una sede.
 * Corresponde a SedeRequestDTO en el backend.
 */
export interface CampusRequest {
  /**
   * Nombre de la sede (NotBlank).
   * @example "Sede Central"
   */
  nombre: string;

  /**
   * Dirección de la sede (Opcional).
   * @example "Av. Universitaria #45-67"
   */
  direccion?: string; // Sin @NotBlank ni @NotNull, es opcional

  /**
   * Ciudad donde se encuentra la sede (Opcional).
   * @example "Armenia"
   */
  ciudad?: string; // Sin @NotBlank ni @NotNull, es opcional
}