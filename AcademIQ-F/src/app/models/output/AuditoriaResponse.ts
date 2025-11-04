
/**
 * DTO de Petición para registrar una acción en la bitácora del sistema.
 * Corresponde a BitacoraRequestDTO en el backend.
 */
export interface AuditoriaRequest {
  /**
   * ID del usuario que realizó la acción (NotNull).
   * Mapea Long de Java a number de TypeScript.
   * @example 3
   */
  usuarioId: number;

  /**
   * Nombre de la acción realizada (NotBlank).
   * @example "CREAR_MATRICULA"
   */
  accion: string;

  /**
   * Entidad sobre la cual se realizó la acción (NotBlank).
   * @example "Matricula"
   */
  entidad: string;

  /**
   * ID de la entidad afectada (NotNull).
   * Mapea Long de Java a number de TypeScript.
   * @example 10
   */
  entidadId: number;

  /**
   * Detalle adicional de la acción (Opcional).
   * @example "El usuario registró la matrícula del estudiante con código 20251025"
   */
  detalle?: string; // Sin @NotBlank ni @NotNull, es opcional

  /**
   * Dirección IP desde la cual se realizó la acción (Opcional).
   * @example "192.168.1.15"
   */
  ip?: string; // Sin @NotBlank ni @NotNull, es opcional
}