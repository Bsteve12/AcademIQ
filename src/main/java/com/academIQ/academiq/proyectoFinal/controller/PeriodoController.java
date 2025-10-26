package com.academIQ.academiq.proyectoFinal.controller;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.PeriodoRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.PeriodoResponseDTO;
import com.academIQ.academiq.proyectoFinal.services.periodoService.interfaces.PeriodoServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Periodos", description = "Gestión de periodos académicos")
@RestController
@RequestMapping("/api/periodos")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class PeriodoController {

    private final PeriodoServiceInterface periodoService;

    @PostMapping
    @Operation(summary = "Crear un nuevo periodo académico")
    public ResponseEntity<PeriodoResponseDTO> crear(@Valid @RequestBody PeriodoRequestDTO dto) {
        return ResponseEntity.ok(periodoService.crear(dto));
    }

    @GetMapping
    @Operation(summary = "Listar todos los periodos académicos")
    public ResponseEntity<List<PeriodoResponseDTO>> listar() {
        return ResponseEntity.ok(periodoService.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar un periodo por ID")
    public ResponseEntity<PeriodoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(periodoService.buscarPorId(id));
    }

    @GetMapping("/activo")
    @Operation(summary = "Obtener el periodo académico activo")
    public ResponseEntity<PeriodoResponseDTO> obtenerPeriodoActivo() {
        return ResponseEntity.ok(periodoService.obtenerPeriodoActivo());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un periodo académico")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        periodoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
