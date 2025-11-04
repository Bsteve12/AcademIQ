
/**
 * DTO de Petición para crear o actualizar un estudiante.
 * Corresponde a EstudianteRequestDTO en el backend de Spring Boot.
 */
export interface EstudianteRequest {
  /**
   * Código único del estudiante (NotBlank).
   * @example "20251234"
   */
  codigo: string;

  /**
   * Nombre del estudiante (NotBlank).
   * @example "Juan"
   */
  nombre: string;

  /**
   * Apellido del estudiante (NotBlank).
   * @example "Pérez"
   */
  apellido: string;

  /**
   * Correo electrónico del estudiante (NotBlank, Email).
   * @example "juan.perez@universidad.edu"
   */
  correo: string;

  /**
   * Teléfono del estudiante (Opcional en el backend, se marca como opcional en TS con '?').
   * @example "+57 3001234567"
   */
  telefono?: string; // Nota el '?' para campos que pueden ser nulos o no enviados

  /**
   * ID del programa al que pertenece el estudiante (NotNull).
   * Mapea Long de Java a number de TypeScript.
   * @example 2
   */
  programaId: number;

  /**
   * Promedio general del estudiante (Double a number). Opcional.
   * @example 3.45
   */
  promedioGeneral?: number; // Opcional

  /**
   * Nivel de riesgo académico (String en Java). Opcional.
   * Si 'NivelRiesgo' es un conjunto de valores fijos, se recomienda usar un Enum o una unión de tipos.
   * @example "Medio"
   */
  nivelRiesgo?: string; // Opcional
}

