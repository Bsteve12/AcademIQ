package com.academIQ.academiq.proyectoFinal.dto.inputDTO;

import com.academIQ.academiq.proyectoFinal.entity.enums.DiaSemana;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Datos de entrada para crear o modificar un horario")
public class HorarioRequestDTO {

    @NotNull
    @Schema(description = "Día de la semana del horario", example = "LUNES")
    private DiaSemana diaSemana;

    @NotNull
    @Schema(description = "Hora de inicio", example = "08:00")
    private LocalTime horaInicio;

    @NotNull
    @Schema(description = "Hora de fin", example = "10:00")
    private LocalTime horaFin;

    @NotNull
    @Schema(description = "ID del grupo al que pertenece el horario", example = "12")
    private Long grupoId;
}
