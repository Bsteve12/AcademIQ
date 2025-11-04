// src/app/models/program-request.interface.ts

/**
 * DTO de Petición para crear o actualizar un programa académico.
 * Corresponde a ProgramaRequestDTO en el backend.
 */
export interface ProgramRequest {
  /**
   * Nombre único del programa (NotBlank).
   * @example "Ingeniería de Sistemas"
   */
  nombre: string;

  /**
   * Facultad a la que pertenece el programa (NotBlank).
   * @example "Facultad de Ingeniería"
   */
  facultad: string;

  /**
   * Duración en semestres del programa (NotNull).
   * Mapea Integer de Java a number de TypeScript.
   * @example 10
   */
  duracionSemestres: number;

  /**
   * ID de la sede a la que pertenece el programa (NotNull).
   * Mapea Long de Java a number de TypeScript.
   * @example 1
   */
  sedeId: number;
}