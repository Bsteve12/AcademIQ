

/**
 * DTO de Petición para registrar un prerrequisito de una asignatura.
 * Corresponde a PrerrequisitoRequestDTO en el backend.
 */
export interface PrerequisiteRequest {
  /**
   * ID de la asignatura principal (NotNull).
   * Mapea Long de Java a number de TypeScript.
   * @example 5
   */
  asignaturaId: number;

  /**
   * ID de la asignatura que actúa como prerrequisito (NotNull).
   * Mapea Long de Java a number de TypeScript.
   * @example 2
   */
  prerrequisitoId: number;
}