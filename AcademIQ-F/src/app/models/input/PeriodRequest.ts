
/**
 * Modelo de datos para un Periodo Académico.
 * Corresponde a PeriodoResponseDTO en el backend.
 */
export interface PeriodResponse {
  /**
   * ID del periodo (Clave primaria). Long de Java -> number de TypeScript.
   * @example 1
   */
  id: number;

  /**
   * Nombre del periodo.
   * @example "2025-1"
   */
  nombre: string;

  /**
   * Fecha de inicio.
   * Mapea LocalDate de Java a string (YYYY-MM-DD) de TypeScript.
   * @example "2025-02-01"
   */
  fechaInicio: string;

  /**
   * Fecha de fin.
   * Mapea LocalDate de Java a string (YYYY-MM-DD) de TypeScript.
   * @example "2025-06-30"
   */
  fechaFin: string;

  /**
   * Indica si el periodo está activo.
   * Mapea 'boolean' primitiva de Java a 'boolean' de TypeScript (siempre requerida).
   * @example true
   */
  activo: boolean;
}