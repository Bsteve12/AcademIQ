

/**
 * DTO de Petición para crear o actualizar una Asignatura.
 * Corresponde a AsignaturaRequestDTO en el backend.
 */
export interface SubjectRequest {
  /**
   * Código único de la asignatura (NotBlank).
   * @example "INF-101"
   */
  codigo: string;

  /**
   * Nombre de la asignatura (NotBlank).
   * @example "Programación I"
   */
  nombre: string;

  /**
   * Cantidad de créditos (NotNull).
   * Mapea Integer de Java a number de TypeScript.
   * En Angular, idealmente se valida que esté entre 1 y 10.
   * @example 3
   */
  creditos: number;

  /**
   * Semestre sugerido en el plan de estudios (Opcional).
   * Mapea Integer de Java a number de TypeScript.
   * @example 1
   */
  semestreSugerido?: number; // Es opcional ya que no tiene @NotNull

  /**
   * ID del programa al que pertenece la asignatura (NotNull).
   * Mapea Long de Java a number de TypeScript.
   * @example 2
   */
  programaId: number;
}