package com.academIQ.academiq.proyectoFinal.dto.outputDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Datos de salida de una ventana académica registrada")
public class VentanaAcademicaResponseDTO {

    @Schema(description = "ID de la ventana académica", example = "1")
    private Long id;

    @Schema(description = "Nombre del periodo asociado", example = "2025-1")
    private String periodoNombre;

    @Schema(description = "Fecha de inicio de inscripciones", example = "2025-01-15")
    private LocalDate fechaInicioInscripcion;

    @Schema(description = "Fecha de fin de inscripciones", example = "2025-01-25")
    private LocalDate fechaFinInscripcion;

    @Schema(description = "Fecha de inicio de retiros", example = "2025-02-10")
    private LocalDate fechaInicioRetiros;

    @Schema(description = "Fecha de fin de retiros", example = "2025-02-20")
    private LocalDate fechaFinRetiros;
}
