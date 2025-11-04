

/**
 * Modelo de datos para un Grupo Académico.
 * Corresponde a GrupoResponseDTO en el backend.
 */
export interface GroupRequest {
  /**
   * ID único del grupo (Clave primaria).
   * Long de Java -> number de TypeScript.
   * @example 1
   */
  id: number;

  /**
   * Código del grupo.
   * @example "GRP-2025-01"
   */
  codigoGrupo: string;

  /**
   * Nombre de la asignatura (Relación simplificada).
   */
  asignatura: string;

  /**
   * Nombre del docente asignado (Relación simplificada).
   */
  docente: string;

  /**
   * Nombre del salón (Relación simplificada).
   * Asumo que puede ser opcional si el salón no ha sido asignado.
   */
  salon?: string; // Opcional si en la BD el salón puede ser null

  /**
   * Periodo académico (Relación simplificada).
   */
  periodo: string;

  /**
   * Cupo máximo permitido.
   * Integer de Java -> number de TypeScript.
   * @example 35
   */
  cupoMaximo: number;

  /**
   * Cupo actual ocupado.
   * Integer de Java -> number de TypeScript.
   * @example 22
   */
  cupoActual: number;
}