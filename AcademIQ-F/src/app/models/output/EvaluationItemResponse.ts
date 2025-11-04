// src/app/models/evaluation-item-request.interface.ts (Ruta sugerida)

/**
 * DTO de Petición para crear o actualizar un ítem de evaluación.
 * Corresponde a EvaluacionItemRequestDTO en el backend.
 */
export interface EvaluationItemRequest {
  /**
   * Nombre del ítem de evaluación (NotBlank).
   * @example "Parcial 1"
   */
  nombreItem: string;

  /**
   * Descripción del ítem de evaluación (Opcional).
   * @example "Evaluación escrita sobre los temas vistos..."
   */
  descripcion?: string; // Sin @NotBlank, es opcional

  /**
   * Porcentaje que representa (NotNull, 0.0 a 100.0).
   * Mapea Double de Java a number de TypeScript.
   * @example 30.0
   */
  porcentaje: number;

  /**
   * Fecha de registro del ítem de evaluación (Opcional).
   * Mapea java.time.LocalDate de Java.
   * En Angular, generalmente se envía como una cadena de texto en formato ISO 8601 (YYYY-MM-DD).
   * @example "2025-10-25"
   */
  fechaRegistro?: string; // Sin @NotNull, es opcional. Se usa 'string' para representar la fecha.

  /**
   * ID de la asignatura asociada (NotNull).
   * Mapea Long de Java a number de TypeScript.
   * @example 5
   */
  asignaturaId: number;
}