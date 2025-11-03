package com.academIQ.academiq.proyectoFinal.controller;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.MatriculaRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.MatriculaResponseDTO;
import com.academIQ.academiq.proyectoFinal.services.matriculaService.interfaces.MatriculaServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Matrículas", description = "Operaciones para gestionar matrículas académicas")
@RestController
@RequestMapping("/api/matriculas")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class MatriculaController {

    private final MatriculaServiceInterface matriculaService;

    @PostMapping
    @Operation(summary = "Crear una matrícula")
    public ResponseEntity<MatriculaResponseDTO> crear(@Valid @RequestBody MatriculaRequestDTO dto) {
        return ResponseEntity.ok(matriculaService.crear(dto));
    }

    @GetMapping
    @Operation(summary = "Listar todas las matrículas")
    public ResponseEntity<List<MatriculaResponseDTO>> listar() {
        return ResponseEntity.ok(matriculaService.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una matrícula por ID")
    public ResponseEntity<MatriculaResponseDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(matriculaService.buscarPorId(id));
    }

    @GetMapping("/estudiante/{id}")
    @Operation(summary = "Listar matrículas de un estudiante específico")
    public ResponseEntity<List<MatriculaResponseDTO>> listarPorEstudiante(@PathVariable Long id) {
        return ResponseEntity.ok(matriculaService.listarPorEstudiante(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una matrícula")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        matriculaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
