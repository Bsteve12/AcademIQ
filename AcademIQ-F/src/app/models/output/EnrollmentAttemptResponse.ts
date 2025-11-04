

/**
 * DTO de Petición para registrar un intento de matrícula.
 * Corresponde a IntentoMatriculaRequestDTO en el backend.
 */
export interface EnrollmentAttemptRequest {
  /**
   * ID del estudiante que intenta matricularse (NotNull).
   * Mapea Long de Java a number de TypeScript.
   * @example 5
   */
  estudianteId: number;

  /**
   * ID del grupo al que intenta matricularse (NotNull).
   * Mapea Long de Java a number de TypeScript.
   * @example 12
   */
  grupoId: number;

  /**
   * Motivo del intento fallido o exitoso (Opcional).
   * @example "CUPO"
   */
  motivo?: string; // Sin @NotNull, es opcional

  /**
   * Fecha y hora del intento (Opcional).
   * Mapea LocalDateTime de Java a string en formato ISO 8601 (YYYY-MM-DDTHH:MM:SS).
   * @example "2025-10-25T09:30:00"
   */
  fechaIntento?: string; // Sin @NotNull, es opcional

  /**
   * Indica si el intento fue exitoso (boolean a boolean).
   * Nota: Las primitivas de Java (boolean) no pueden ser null, pero si la intención es que el campo sea opcional en el DTO,
   * se le puede poner el '?' y luego se manejará como 'boolean | undefined' en TS.
   * @example true
   */
  exitoso?: boolean; // Es opcional, aunque 'boolean' es una primitiva, si no tiene @NotNull la convención en TS es usar '?'
}