// src/app/models/schedule-request.interface.ts

import { DayOfWeek } from '../enums/DayOfWeek';

/**
 * DTO de Petición para crear o modificar un horario.
 * Corresponde a HorarioRequestDTO en el backend.
 */
export interface ScheduleRequest {
  /**
   * Día de la semana del horario (NotNull).
   * Mapea el enum DiaSemana de Java a nuestro enum DayOfWeek de TypeScript.
   * @example DayOfWeek.LUNES
   */
  diaSemana: DayOfWeek;

  /**
   * Hora de inicio (NotNull).
   * Mapea LocalTime de Java a string en formato HH:MM (ISO 8601).
   * @example "08:00"
   */
  horaInicio: string;

  /**
   * Hora de fin (NotNull).
   * Mapea LocalTime de Java a string en formato HH:MM (ISO 8601).
   * @example "10:00"
   */
  horaFin: string;

  /**
   * ID del grupo al que pertenece el horario (NotNull).
   * Mapea Long de Java a number de TypeScript.
   * @example 12
   */
  grupoId: number;
}