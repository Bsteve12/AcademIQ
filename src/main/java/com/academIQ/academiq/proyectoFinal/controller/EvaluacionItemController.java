package com.academIQ.academiq.proyectoFinal.controller;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.EvaluacionItemRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.EvaluacionItemResponseDTO;
import com.academIQ.academiq.proyectoFinal.services.evaluacionItemService.interfaces.EvaluacionItemServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "EvaluacionItem", description = "Gestión de ítems de evaluación por asignatura")
@RestController
@RequestMapping("/api/evaluaciones-items")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class EvaluacionItemController {

    private final EvaluacionItemServiceInterface evaluacionItemService;

    @PostMapping
    @Operation(summary = "Crear un ítem de evaluación")
    public ResponseEntity<EvaluacionItemResponseDTO> crear(@Valid @RequestBody EvaluacionItemRequestDTO dto) {
        return ResponseEntity.ok(evaluacionItemService.crear(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un ítem de evaluación")
    public ResponseEntity<EvaluacionItemResponseDTO> actualizar(@PathVariable Long id, @Valid @RequestBody EvaluacionItemRequestDTO dto) {
        return ResponseEntity.ok(evaluacionItemService.actualizar(id, dto));
    }

    @GetMapping
    @Operation(summary = "Listar todos los ítems de evaluación")
    public ResponseEntity<List<EvaluacionItemResponseDTO>> listar() {
        return ResponseEntity.ok(evaluacionItemService.listar());
    }

    @GetMapping("/asignatura/{asignaturaId}")
    @Operation(summary = "Listar ítems de evaluación por asignatura")
    public ResponseEntity<List<EvaluacionItemResponseDTO>> listarPorAsignatura(@PathVariable Long asignaturaId) {
        return ResponseEntity.ok(evaluacionItemService.listarPorAsignatura(asignaturaId));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar ítem de evaluación por ID")
    public ResponseEntity<EvaluacionItemResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(evaluacionItemService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un ítem de evaluación")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        evaluacionItemService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
