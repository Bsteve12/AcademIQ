// src/app/models/grade-request.interface.ts (Ruta sugerida)

/**
 * DTO de Petición para registrar o actualizar una calificación.
 * Corresponde a CalificacionRequestDTO en el backend.
 */
export interface GradeRequest {
  /**
   * ID de la matrícula asociada (NotNull).
   * Mapea Long de Java a number de TypeScript.
   * @example 12
   */
  matriculaId: number;

  /**
   * Nota del primer parcial (Opcional, pero si se envía debe estar entre 0 y 5).
   * Mapea Double de Java a number de TypeScript.
   * @example 3.5
   */
  nota1?: number; // Sin @NotNull, por lo que es opcional

  /**
   * Nota del segundo parcial (Opcional, pero si se envía debe estar entre 0 y 5).
   * @example 4.0
   */
  nota2?: number; // Sin @NotNull, por lo que es opcional

  /**
   * Nota del tercer parcial (Opcional, pero si se envía debe estar entre 0 y 5).
   * @example 4.8
   */
  nota3?: number; // Sin @NotNull, por lo que es opcional
}