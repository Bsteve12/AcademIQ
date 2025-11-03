package com.academIQ.academiq.proyectoFinal.controller;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.IntentoMatriculaRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.IntentoMatriculaResponseDTO;
import com.academIQ.academiq.proyectoFinal.services.intentoMatriculaService.interfaces.IntentoMatriculaServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Intentos de Matrícula", description = "Operaciones para registrar y consultar intentos de matrícula")
@RestController
@RequestMapping("/api/intentos-matricula")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class IntentoMatriculaController {

    private final IntentoMatriculaServiceInterface intentoService;

    @PostMapping
    @Operation(summary = "Registrar un nuevo intento de matrícula")
    public ResponseEntity<IntentoMatriculaResponseDTO> registrar(@RequestBody IntentoMatriculaRequestDTO dto) {
        return ResponseEntity.ok(intentoService.registrar(dto));
    }

    @GetMapping
    @Operation(summary = "Listar todos los intentos de matrícula")
    public ResponseEntity<List<IntentoMatriculaResponseDTO>> listar() {
        return ResponseEntity.ok(intentoService.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar un intento de matrícula por su ID")
    public ResponseEntity<IntentoMatriculaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(intentoService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un intento de matrícula")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        intentoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
