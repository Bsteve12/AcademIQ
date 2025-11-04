
/**
 * Modelo de datos para un Intento de Matrícula.
 * Corresponde a IntentoMatriculaResponseDTO en el backend.
 */
export interface EnrollmentAttemptRequest {
  /**
   * ID del intento de matrícula (Clave primaria). Long de Java -> number de TypeScript.
   * @example 101
   */
  id: number;

  /**
   * Nombre del estudiante (Relación simplificada).
   */
  estudianteNombre: string;

  /**
   * Código del grupo (Relación simplificada).
   */
  grupoCodigo: string;

  /**
   * Motivo del intento (Ej. CUPO, CHOQUE).
   * Asumo que puede ser nulo si el intento fue exitoso y no se registró un motivo.
   * @example "CHOQUE"
   */
  motivo?: string; // Opcional

  /**
   * Fecha y hora del intento.
   * Mapea LocalDateTime de Java a string (YYYY-MM-DDTHH:MM:SS) de TypeScript.
   * @example "2025-10-25T09:30:00"
   */
  fechaIntento: string;

  /**
   * Resultado del intento.
   * Mapea 'boolean' primitiva de Java a 'boolean' de TypeScript (siempre requerida).
   * @example false
   */
  exitoso: boolean;
}