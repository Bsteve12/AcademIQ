

/**
 * Modelo de datos para un Detalle de Calificación.
 * Corresponde a CalificacionDetalleResponseDTO en el backend.
 */
export interface GradeDetailRequest {
  /**
   * ID único del detalle de calificación.
   * Long de Java -> number de TypeScript.
   * @example 101
   */
  id: number;

  /**
   * ID del ítem de evaluación.
   * @example 7
   */
  evaluacionItemId: number;

  /**
   * Nombre o descripción del ítem de evaluación (Relación simplificada).
   * @example "Parcial 1 - Teoría"
   */
  evaluacionItemDescripcion: string;

  /**
   * ID de la calificación padre.
   * @example 45
   */
  calificacionId: number;

  /**
   * Nota registrada para el ítem.
   * Double de Java -> number de TypeScript.
   * @example 4.25
   */
  nota: number;
}