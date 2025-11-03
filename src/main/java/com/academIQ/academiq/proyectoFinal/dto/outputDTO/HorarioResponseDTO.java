package com.academIQ.academiq.proyectoFinal.dto.outputDTO;

import com.academIQ.academiq.proyectoFinal.entity.enums.DiaSemana;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Respuesta con la información del horario")
public class HorarioResponseDTO {

    @Schema(description = "ID del horario", example = "1")
    private Long id;

    @Schema(description = "Día de la semana", example = "LUNES")
    private DiaSemana diaSemana;

    @Schema(description = "Hora de inicio", example = "08:00")
    private LocalTime horaInicio;

    @Schema(description = "Hora de fin", example = "10:00")
    private LocalTime horaFin;

    @Schema(description = "Código del grupo", example = "BD2-G1")
    private String grupoCodigo;
}
