

/**
 * Modelo de datos para un registro de Bitácora.
 * Corresponde a BitacoraResponseDTO en el backend.
 */
export interface AuditoriaRequest {
  /**
   * ID del registro de bitácora (clave primaria).
   * Long de Java -> number de TypeScript.
   * @example 15
   */
  id: number;

  /**
   * Acción registrada (Ej. CREAR_MATRICULA).
   */
  accion: string;

  /**
   * Entidad afectada (Ej. Matricula).
   */
  entidad: string;

  /**
   * ID de la entidad afectada.
   * Long de Java -> number de TypeScript.
   * @example 10
   */
  entidadId: number;

  /**
   * Detalle adicional de la acción (Puede ser opcional/null en la BD).
   */
  detalle?: string; // Asumo que es nullable

  /**
   * Dirección IP desde la cual se realizó la acción (Puede ser opcional/null en la BD).
   * @example "192.168.1.15"
   */
  ip?: string; // Asumo que es nullable

  /**
   * Fecha y hora del registro.
   * Mapea LocalDateTime de Java a string (YYYY-MM-DDTHH:MM:SS) de TypeScript.
   * @example "2025-10-25T19:42:00"
   */
  fechaHora: string;

  /**
   * Nombre del usuario que ejecutó la acción (Relación simplificada).
   */
  usuarioNombre: string;
}