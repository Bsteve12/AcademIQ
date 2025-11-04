// src/app/models/schedule-response.interface.ts

import { DayOfWeek } from '../enums/DayOfWeek';

/**
 * Modelo de datos para un Horario.
 * Corresponde a HorarioResponseDTO en el backend.
 */
export interface ScheduleRequest {
  /**
   * ID único del horario (Clave primaria).
   * Long de Java -> number de TypeScript.
   * @example 1
   */
  id: number;

  /**
   * Día de la semana.
   * Mapea DiaSemana (Enum de Java) a DayOfWeek (Enum de TypeScript).
   * @example DayOfWeek.LUNES
   */
  diaSemana: DayOfWeek;

  /**
   * Hora de inicio.
   * Mapea LocalTime de Java a string (formato HH:MM:SS) de TypeScript.
   * @example "08:00"
   */
  horaInicio: string;

  /**
   * Hora de fin.
   * Mapea LocalTime de Java a string (formato HH:MM:SS) de TypeScript.
   * @example "10:00"
   */
  horaFin: string;

  /**
   * Código del grupo al que pertenece el horario (Relación simplificada).
   * @example "BD2-G1"
   */
  grupoCodigo: string;
}