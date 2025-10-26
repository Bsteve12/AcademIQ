package com.academIQ.academiq.proyectoFinal.controller;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.CalificacionRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.CalificacionResponseDTO;
import com.academIQ.academiq.proyectoFinal.services.calificacionService.interfaces.CalificacionServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Calificaciones", description = "Operaciones para gestionar las calificaciones de los estudiantes")
@RestController
@RequestMapping("/api/calificaciones")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CalificacionController {

    private final CalificacionServiceInterface calificacionService;

    // -------------------------------
    // Crear calificación
    // -------------------------------
    @PostMapping
    @Operation(summary = "Registrar una nueva calificación")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Calificación creada correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos o matrícula duplicada"),
            @ApiResponse(responseCode = "404", description = "Matrícula no encontrada")
    })
    public ResponseEntity<CalificacionResponseDTO> crear(
            @RequestBody CalificacionRequestDTO dto) {
        return ResponseEntity.ok(calificacionService.crear(dto));
    }

    // -------------------------------
    // Actualizar calificación existente
    // -------------------------------
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar calificación existente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Calificación actualizada correctamente"),
            @ApiResponse(responseCode = "404", description = "Calificación no encontrada")
    })
    public ResponseEntity<CalificacionResponseDTO> actualizar(
            @Parameter(description = "ID de la calificación a actualizar") @PathVariable Long id,
            @RequestBody CalificacionRequestDTO dto) {
        return ResponseEntity.ok(calificacionService.actualizar(id, dto));
    }

    // -------------------------------
    // Obtener calificación por ID
    // -------------------------------
    @GetMapping("/{id}")
    @Operation(summary = "Obtener una calificación por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Calificación encontrada"),
            @ApiResponse(responseCode = "404", description = "Calificación no encontrada")
    })
    public ResponseEntity<CalificacionResponseDTO> obtenerPorId(
            @Parameter(description = "ID de la calificación") @PathVariable Long id) {
        return ResponseEntity.ok(calificacionService.buscarPorId(id));
    }

    // -------------------------------
    // Listar todas las calificaciones
    // -------------------------------
    @GetMapping
    @Operation(summary = "Listar todas las calificaciones registradas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Listado obtenido correctamente")
    })
    public ResponseEntity<List<CalificacionResponseDTO>> listar() {
        return ResponseEntity.ok(calificacionService.listar());
    }

    // -------------------------------
    // Eliminar calificación
    // -------------------------------
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una calificación")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Calificación eliminada correctamente"),
            @ApiResponse(responseCode = "404", description = "Calificación no encontrada")
    })
    public ResponseEntity<Void> eliminar(
            @Parameter(description = "ID de la calificación a eliminar") @PathVariable Long id) {
        calificacionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
