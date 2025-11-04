

/**
 * DTO de Petición para crear una matrícula.
 * Corresponde a MatriculaRequestDTO en el backend.
 */
export interface EnrollmentRequest {
  /**
   * ID del estudiante (NotNull).
   * Mapea Long de Java a number de TypeScript.
   * @example 5
   */
  estudianteId: number;

  /**
   * ID de la asignatura (NotNull).
   * Mapea Long de Java a number de TypeScript.
   * @example 3
   */
  asignaturaId: number;

  /**
   * ID del periodo (NotNull).
   * Mapea Long de Java a number de TypeScript.
   * @example 1
   */
  periodoId: number;

  /**
   * Estado inicial de la matrícula (NotBlank).
   * Si 'Estado' es un enum en el backend, es mejor usar un Enum o Type Union en TS.
   * @example "Activa"
   */
  estado: string;
}