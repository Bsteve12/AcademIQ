

/**
 * DTO de Petición para registrar un historial académico.
 * Corresponde a HistorialAcademicoRequestDTO en el backend.
 */
export interface AcademicHistoryRequest {
  /**
   * ID del estudiante (NotNull).
   * Mapea Long de Java a number de TypeScript.
   * @example 5
   */
  estudianteId: number;

  /**
   * ID de la asignatura (NotNull).
   * Mapea Long de Java a number de TypeScript.
   * @example 12
   */
  asignaturaId: number;

  /**
   * ID del periodo académico (NotNull).
   * Mapea Long de Java a number de TypeScript.
   * @example 3
   */
  periodoId: number;

  /**
   * Nota final obtenida (Opcional).
   * Mapea Double de Java a number de TypeScript.
   * @example 4.5
   */
  notaFinal?: number; // Sin @NotNull, es opcional

  /**
   * Resultado final del estudiante ("APROBADO", "REPROBADO", etc.) (Opcional).
   * Si es un enum en el backend, es mejor usar un Type o Enum en TS.
   * @example "APROBADO"
   */
  resultado?: string; // Sin @NotNull, es opcional

  /**
   * Número de intento de la asignatura (Opcional).
   * Mapea Integer de Java a number de TypeScript.
   * @example 1
   */
  intentoNumero?: number; // Sin @NotNull, es opcional

  /**
   * Fecha de registro en el historial (Opcional).
   * Mapea LocalDate de Java a string (YYYY-MM-DD) de TypeScript.
   * @example "2025-10-25"
   */
  fechaRegistro?: string; // Sin @NotNull, es opcional
}