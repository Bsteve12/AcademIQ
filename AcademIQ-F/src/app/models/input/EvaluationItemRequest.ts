

/**
 * Modelo de datos para un Ítem de Evaluación.
 * Corresponde a EvaluacionItemResponseDTO en el backend.
 */
export interface EvaluationItemRequest {
  /**
   * ID único del ítem de evaluación (Clave primaria).
   * Long de Java -> number de TypeScript.
   * @example 12
   */
  id: number;

  /**
   * Nombre del ítem de evaluación.
   */
  nombreItem: string;

  /**
   * Descripción del ítem de evaluación (Asumo que es opcional/nullable en BD).
   */
  descripcion?: string; // Opcional

  /**
   * Porcentaje que aporta a la nota final.
   * Double de Java -> number de TypeScript.
   * @example 30.0
   */
  porcentaje: number;

  /**
   * Fecha de registro del ítem.
   * Mapea LocalDate de Java a string (YYYY-MM-DD) de TypeScript.
   * @example "2025-10-25"
   */
  fechaRegistro: string;

  /**
   * Nombre de la asignatura asociada (Relación simplificada).
   * @example "Bases de Datos II"
   */
  asignaturaNombre: string;
}