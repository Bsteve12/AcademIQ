

/**
 * DTO de Petición para crear o actualizar un salón (classroom).
 * Corresponde a SalonRequestDTO en el backend.
 */
export interface ClassroomRequest {
  /**
   * Nombre del salón (NotBlank).
   * @example "Lab. Sistemas 201"
   */
  nombre: string;

  /**
   * Ubicación o edificio (Opcional).
   * @example "Bloque A - Piso 2"
   */
  ubicacion?: string; // Sin @NotBlank ni @NotNull, es opcional

  /**
   * Capacidad máxima (NotNull, Mínimo 1).
   * Mapea Integer de Java a number de TypeScript.
   * @example 40
   */
  capacidad: number;

  /**
   * ID de la sede a la que pertenece el salón (NotNull).
   * Mapea Long de Java a number de TypeScript.
   * @example 1
   */
  sedeId: number;
}