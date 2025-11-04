

/**
 * Modelo de datos para una Calificación (Registro de notas por matrícula).
 * Corresponde a CalificacionResponseDTO en el backend.
 */
export interface GradeRequest {
  /**
   * ID único de la calificación.
   * Long de Java -> number de TypeScript.
   * @example 45
   */
  id: number;

  /**
   * ID de la matrícula asociada (clave foránea).
   * @example 12
   */
  matriculaId: number;

  /**
   * Nota 1 del estudiante (Double a number).
   * @example 3.5
   */
  nota1?: number; // Asumo que puede ser nulo si aún no se ha registrado

  /**
   * Nota 2 del estudiante (Double a number).
   * @example 4.0
   */
  nota2?: number; // Asumo que puede ser nulo

  /**
   * Nota 3 del estudiante (Double a number).
   * @example 4.8
   */
  nota3?: number; // Asumo que puede ser nulo

  /**
   * Nota final (promedio ponderado o automática).
   * @example 4.1
   */
  notaFinal?: number; // Asumo que puede ser nulo hasta que se cierre el periodo
}