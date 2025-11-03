package com.academIQ.academiq.proyectoFinal.controller;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.CalificacionDetalleRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.CalificacionDetalleResponseDTO;
import com.academIQ.academiq.proyectoFinal.services.calificacionDetalleService.interfaces.CalificacionDetalleServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "CalificacionesDetalle", description = "Detalles por ítem de evaluación")
@RestController
@RequestMapping("/api/calificaciones-detalle")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CalificacionDetalleController {

    private final CalificacionDetalleServiceInterface detalleService;

    @PostMapping
    @Operation(summary = "Crear un detalle de calificación")
    public ResponseEntity<CalificacionDetalleResponseDTO> crear(@Valid @RequestBody CalificacionDetalleRequestDTO dto) {
        return ResponseEntity.ok(detalleService.crear(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un detalle de calificación")
    public ResponseEntity<CalificacionDetalleResponseDTO> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody CalificacionDetalleRequestDTO dto) {
        return ResponseEntity.ok(detalleService.actualizar(id, dto));
    }

    @GetMapping
    @Operation(summary = "Listar todos los detalles de calificaciones")
    public ResponseEntity<List<CalificacionDetalleResponseDTO>> listar() {
        return ResponseEntity.ok(detalleService.listar());
    }

    @GetMapping("/calificacion/{calificacionId}")
    @Operation(summary = "Listar detalles por calificación")
    public ResponseEntity<List<CalificacionDetalleResponseDTO>> listarPorCalificacion(@PathVariable Long calificacionId) {
        return ResponseEntity.ok(detalleService.listarPorCalificacion(calificacionId));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un detalle por ID")
    public ResponseEntity<CalificacionDetalleResponseDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(detalleService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un detalle de calificación")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        detalleService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
