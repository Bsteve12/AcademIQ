

/**
 * Modelo de datos para un Salón.
 * Corresponde a SalonRequestDTO en el backend.
 */
export interface ClassroomRequest {
  /**
   * ID del salón (Clave primaria). Long de Java -> number de TypeScript.
   * @example 3
   */
  id: number;

  /**
   * Nombre del salón.
   */
  nombre: string;

  /**
   * Ubicación o edificio (Asumo que puede ser opcional/nullable).
   * @example "Bloque A - Piso 2"
   */
  ubicacion?: string; // Opcional

  /**
   * Capacidad máxima. Integer de Java -> number de TypeScript.
   * @example 40
   */
  capacidad: number;

  /**
   * Nombre de la sede a la que pertenece (Relación simplificada).
   * @example "Sede Central"
   */
  sede: string;
}