// src/app/models/group-request.interface.ts (Ruta sugerida)

/**
 * DTO de Petición para crear o actualizar un grupo académico.
 * Corresponde a GrupoRequestDTO en el backend.
 */
export interface GroupRequest {
  /**
   * Código único del grupo (NotBlank).
   * @example "GRP-2025-01"
   */
  codigoGrupo: string;

  /**
   * ID de la asignatura asociada (NotNull).
   * Mapea Long de Java a number de TypeScript.
   * @example 10
   */
  asignaturaId: number;

  /**
   * ID del docente asignado (NotNull).
   * Mapea Long de Java a number de TypeScript.
   * @example 7
   */
  docenteId: number;

  /**
   * ID del periodo académico (NotNull).
   * Mapea Long de Java a number de TypeScript.
   * @example 3
   */
  periodoId: number;

  /**
   * ID del salón donde se dicta la clase (Opcional).
   * Mapea Long de Java a number de TypeScript.
   * @example 5
   */
  salonId?: number; // Sin @NotNull, por lo que es opcional

  /**
   * Número máximo de estudiantes permitidos (NotNull).
   * Mapea Integer de Java a number de TypeScript.
   * @example 35
   */
  cupoMaximo: number;
}