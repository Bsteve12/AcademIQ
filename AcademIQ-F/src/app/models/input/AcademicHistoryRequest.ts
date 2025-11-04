
/**
 * Modelo de datos para un registro de Historial Académico.
 * Corresponde a HistorialAcademicoResponseDTO en el backend.
 */
export interface AcademicHistoryRequest {
  /**
   * ID del registro (Clave primaria). Long de Java -> number de TypeScript.
   * @example 101
   */
  id: number;

  /**
   * Nombre del estudiante (Relación simplificada).
   */
  estudianteNombre: string;

  /**
   * Nombre de la asignatura (Relación simplificada).
   */
  asignaturaNombre: string;

  /**
   * Nombre del periodo académico (Relación simplificada).
   */
  periodoNombre: string;

  /**
   * Nota final del estudiante (Double a number).
   * @example 4.0
   */
  notaFinal?: number; // Asumo que puede ser nula si el periodo aún no finaliza

  /**
   * Resultado final ("APROBADO", "REPROBADO", etc.).
   * @example "APROBADO"
   */
  resultado?: string; // Asumo que puede ser nulo hasta el cierre de notas

  /**
   * Número de intento de la asignatura (Integer a number).
   * @example 1
   */
  intentoNumero: number;

  /**
   * Fecha de registro. LocalDate de Java -> string (YYYY-MM-DD) de TypeScript.
   * @example "2025-10-25"
   */
  fechaRegistro: string;
}