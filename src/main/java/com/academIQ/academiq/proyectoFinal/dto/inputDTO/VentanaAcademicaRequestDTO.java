package com.academIQ.academiq.proyectoFinal.dto.inputDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Datos de entrada para crear o actualizar una ventana académica")
public class VentanaAcademicaRequestDTO {

    @NotNull
    @Schema(description = "ID del periodo asociado a la ventana académica", example = "3")
    private Long periodoId;

    @NotNull
    @Schema(description = "Fecha de inicio de inscripciones", example = "2025-01-15")
    private LocalDate fechaInicioInscripcion;

    @NotNull
    @Schema(description = "Fecha de finalización de inscripciones", example = "2025-01-25")
    private LocalDate fechaFinInscripcion;

    @NotNull
    @Schema(description = "Fecha de inicio de retiros de asignaturas", example = "2025-02-10")
    private LocalDate fechaInicioRetiros;

    @NotNull
    @Schema(description = "Fecha de finalización de retiros de asignaturas", example = "2025-02-20")
    private LocalDate fechaFinRetiros;
}
