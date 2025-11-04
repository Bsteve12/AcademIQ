
/**
 * DTO de Petición para crear o actualizar una ventana académica.
 * Corresponde a VentanaAcademicaRequestDTO en el backend.
 */
export interface AcademicWindowRequest {
  /**
   * ID del periodo asociado a la ventana académica (NotNull).
   * Mapea Long de Java a number de TypeScript.
   * @example 3
   */
  periodoId: number;

  /**
   * Fecha de inicio de inscripciones (NotNull).
   * Mapea LocalDate de Java a string (YYYY-MM-DD).
   * @example "2025-01-15"
   */
  fechaInicioInscripcion: string;

  /**
   * Fecha de finalización de inscripciones (NotNull).
   * Mapea LocalDate de Java a string (YYYY-MM-DD).
   * @example "2025-01-25"
   */
  fechaFinInscripcion: string;

  /**
   * Fecha de inicio de retiros de asignaturas (NotNull).
   * Mapea LocalDate de Java a string (YYYY-MM-DD).
   * @example "2025-02-10"
   */
  fechaInicioRetiros: string;

  /**
   * Fecha de finalización de retiros de asignaturas (NotNull).
   * Mapea LocalDate de Java a string (YYYY-MM-DD).
   * @example "2025-02-20"
   */
  fechaFinRetiros: string;
}