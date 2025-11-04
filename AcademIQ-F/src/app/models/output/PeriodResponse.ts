

/**
 * DTO de Petición para crear o actualizar un periodo académico.
 * Corresponde a PeriodoRequestDTO en el backend.
 */
export interface PeriodRequest {
  /**
   * Nombre del periodo académico (NotBlank).
   * @example "2025-1"
   */
  nombre: string;

  /**
   * Fecha de inicio del periodo (NotNull).
   * Mapea LocalDate de Java a string (YYYY-MM-DD) de TypeScript.
   * @example "2025-02-01"
   */
  fechaInicio: string;

  /**
   * Fecha de fin del periodo (NotNull).
   * Mapea LocalDate de Java a string (YYYY-MM-DD) de TypeScript.
   * @example "2025-06-30"
   */
  fechaFin: string;

  /**
   * Indica si el periodo está activo (boolean).
   * En Java, al ser una primitiva, es requerido, por lo que no lleva '?' en TS.
   * @example true
   */
  activo: boolean;
}