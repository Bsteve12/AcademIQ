

/**
 * DTO de Petición para crear o actualizar un Docente.
 * Corresponde a DocenteRequestDTO en el backend.
 * (DocentRequest para el nombre en inglés)
 */
export interface DocentRequest {
  /**
   * Nombre completo del docente (NotBlank).
   * @example "María Gómez"
   */
  nombre: string;

  /**
   * Correo institucional del docente (NotBlank, Email).
   * @example "maria.gomez@universidad.edu"
   */
  correo: string;

  /**
   * Teléfono del docente (Opcional).
   * @example "+57 3120000000"
   */
  telefono?: string; // Sin @NotBlank, es opcional

  /**
   * Especialidad del docente (Opcional).
   * @example "Algoritmos"
   */
  especialidad?: string; // Sin @NotBlank, es opcional

  /**
   * Lista de IDs de asignaturas que dicta el docente.
   * Mapea List<Long> de Java a array de numbers de TypeScript (number[]).
   * @example [1, 2, 3]
   */
  asignaturaIds?: number[]; // Es opcional, ya que List<Long> en Java puede ser null o una lista vacía
}