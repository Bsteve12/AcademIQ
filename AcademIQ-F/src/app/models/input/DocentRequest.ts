

/**
 * Modelo de datos para un Docente.
 * Corresponde a DocenteResponseDTO en el backend.
 */
export interface DocentRequest {
  /**
   * ID único del docente.
   * Long de Java -> number de TypeScript.
   * @example 12
   */
  id: number;

  /**
   * Nombre completo del docente.
   */
  nombre: string;

  /**
   * Correo institucional del docente.
   */
  correo: string;

  /**
   * Teléfono (asumo que puede ser nulo en BD).
   * @example "+57 3120000000"
   */
  telefono?: string; // Opcional

  /**
   * Especialidad (asumo que puede ser nulo en BD).
   * @example "Algoritmos"
   */
  especialidad?: string; // Opcional

  /**
   * Lista de códigos o nombres de asignaturas que dicta.
   * Mapea List<String> de Java a array de strings de TypeScript (string[]).
   */
  asignaturas: string[]; // No es opcional, pero podría ser un array vacío ([])
}