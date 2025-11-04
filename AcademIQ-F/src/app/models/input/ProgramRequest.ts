

/**
 * Modelo de datos para un Programa Académico.
 * Corresponde a ProgramaResponseDTO en el backend.
 */
export interface ProgramRequest {
  /**
   * ID del programa (Clave primaria). Long de Java -> number de TypeScript.
   * @example 5
   */
  id: number;

  /**
   * Nombre del programa.
   */
  nombre: string;

  /**
   * Facultad a la que pertenece el programa.
   */
  facultad: string;

  /**
   * Duración en semestres. Integer de Java -> number de TypeScript.
   * @example 10
   */
  duracionSemestres: number;

  /**
   * Nombre de la sede asociada (Relación simplificada).
   * @example "Sede Bogotá"
   */
  sede: string;

  /**
   * Cantidad aproximada de estudiantes (opcional/calculado). Integer de Java -> number de TypeScript.
   * @example 120
   */
  estudiantesCount?: number; // Opcional, ya que es un conteo que puede ser nulo o cero.
}