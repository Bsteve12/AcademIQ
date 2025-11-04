
/**
 * Modelo de datos para una Ventana Académica (Fechas límite).
 * Corresponde a VentanaAcademicaResponseDTO en el backend.
 */
export interface AcademicWindowResponse {
  /**
   * ID de la ventana académica (Clave primaria). Long de Java -> number de TypeScript.
   * @example 1
   */
  id: number;

  /**
   * Nombre del periodo asociado (Relación simplificada).
   * @example "2025-1"
   */
  periodoNombre: string;

  /**
   * Fecha de inicio de inscripciones. LocalDate de Java -> string (YYYY-MM-DD).
   * @example "2025-01-15"
   */
  fechaInicioInscripcion: string;

  /**
   * Fecha de fin de inscripciones. LocalDate de Java -> string (YYYY-MM-DD).
   * @example "2025-01-25"
   */
  fechaFinInscripcion: string;

  /**
   * Fecha de inicio de retiros. LocalDate de Java -> string (YYYY-MM-DD).
   * @example "2025-02-10"
   */
  fechaInicioRetiros: string;

  /**
   * Fecha de fin de retiros. LocalDate de Java -> string (YYYY-MM-DD).
   * @example "2025-02-20"
   */
  fechaFinRetiros: string;
}