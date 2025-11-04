// src/app/models/grade-detail-request.interface.ts (Ruta sugerida)

/**
 * DTO de Petición para crear o actualizar un detalle de calificación.
 * Corresponde a CalificacionDetalleRequestDTO en el backend.
 */
export interface GradeDetailRequest {
  /**
   * ID del ítem de evaluación (NotNull).
   * Mapea Long de Java a number de TypeScript.
   * @example 7
   */
  evaluacionItemId: number;

  /**
   * ID de la calificación padre (NotNull).
   * Mapea Long de Java a number de TypeScript.
   * @example 45
   */
  calificacionId: number;

  /**
   * Nota obtenida para este ítem (NotNull).
   * Mapea Double de Java a number de TypeScript.
   * En Angular, el campo de formulario debe usar validadores min(0.0) y max(5.0).
   * @example 4.25
   */
  nota: number;
}