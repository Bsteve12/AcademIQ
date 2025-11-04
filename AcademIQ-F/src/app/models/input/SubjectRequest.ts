

/**
 * DTO de Petición para crear o actualizar una Asignatura.
 * Corresponde a AsignaturaRequestDTO en el backend.
 */
export interface SubjectRequest {
  /**
   * Código único de la asignatura (NotBlank).
   */
  codigo: string;

  /**
   * Nombre de la asignatura (NotBlank).
   */
  nombre: string;

  /**
   * Cantidad de créditos (NotNull, Min 1, Max 10).
   * Integer de Java -> number de TypeScript.
   */
  creditos: number;

  /**
   * Semestre sugerido en el plan de estudios (Opcional).
   * Integer de Java -> number de TypeScript.
   */
  semestreSugerido?: number; // Opcional

  /**
   * ID del programa al que pertenece la asignatura (NotNull).
   * Long de Java -> number de TypeScript.
   */
  programaId: number;
}