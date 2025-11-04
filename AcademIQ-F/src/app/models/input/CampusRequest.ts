

/**
 * Modelo de datos para una Sede (Campus).
 * Corresponde a SedeRequestDTO en el backend.
 */
export interface CampusRequest {
  /**
   * ID único de la sede (Clave primaria). Long de Java -> number de TypeScript.
   * @example 1
   */
  id: number;

  /**
   * Nombre de la sede.
   * @example "Sede Central"
   */
  nombre: string;

  /**
   * Dirección de la sede (Asumo que puede ser opcional/nullable).
   * @example "Av. Universitaria #45-67"
   */
  direccion?: string; // Opcional

  /**
   * Ciudad donde se encuentra la sede (Asumo que puede ser opcional/nullable).
   * @example "Armenia"
   */
  ciudad?: string; // Opcional
}