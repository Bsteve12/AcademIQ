

/**
 * Modelo de datos para un Prerrequisito de Asignatura.
 * Corresponde a PrerrequisitoRequestDTO en el backend.
 */
export interface PrerequisiteRequest {
  /**
   * ID del registro de prerrequisito (Clave primaria). Long de Java -> number de TypeScript.
   * @example 10
   */
  id: number;

  /**
   * Nombre de la asignatura principal (Relación simplificada).
   */
  asignaturaNombre: string;

  /**
   * Nombre de la asignatura que actúa como prerrequisito (Relación simplificada).
   */
  prerrequisitoNombre: string;
}