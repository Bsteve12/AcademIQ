

/**
 * Modelo de datos para una Matrícula.
 * Corresponde a MatriculaResponseDTO en el backend.
 */
export interface EnrollmentResponse {
  /**
   * ID de la matrícula (Clave primaria). Long de Java -> number de TypeScript.
   * @example 10
   */
  id: number;

  /**
   * Nombre completo del estudiante (Relación simplificada).
   */
  estudiante: string;

  /**
   * Asignatura matriculada (Relación simplificada).
   */
  asignatura: string;

  /**
   * Periodo académico (Relación simplificada).
   */
  periodo: string;

  /**
   * Estado actual de la matrícula ("Activa", "Retirada", "Finalizada").
   * @example "Activa"
   */
  estado: string;
}