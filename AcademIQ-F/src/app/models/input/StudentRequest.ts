

/**
 * Modelo de datos para un Estudiante.
 * Corresponde a EstudianteResponseDTO en el backend.
 */
export interface StudentRequest {
  /**
   * ID interno del estudiante (Clave primaria). Long -> number.
   * @example 15
   */
  id: number;

  /**
   * Código único del estudiante.
   */
  codigo: string;

  /**
   * Nombre completo del estudiante.
   */
  nombreCompleto: string;

  /**
   * Correo electrónico del estudiante.
   */
  correo: string;

  /**
   * Teléfono del estudiante (Opcional si es nullable en BD).
   */
  telefono?: string; 

  /**
   * Nombre del programa académico al que pertenece (Relación simplificada).
   */
  programa: string;

  /**
   * Promedio general (Double -> number. Opcional).
   * @example 3.45
   */
  promedioGeneral?: number; 

  /**
   * Nivel de riesgo académico (String. Opcional).
   */
  nivelRiesgo?: string; 
}