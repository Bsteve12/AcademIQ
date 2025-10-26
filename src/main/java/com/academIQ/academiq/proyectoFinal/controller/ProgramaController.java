package com.academIQ.academiq.proyectoFinal.controller;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.ProgramaRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.ProgramaResponseDTO;
import com.academIQ.academiq.proyectoFinal.services.programaService.interfaces.ProgramaServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Programas", description = "Operaciones para gestionar los programas académicos")
@RestController
@RequestMapping("/api/programas")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ProgramaController {

    private final ProgramaServiceInterface programaService;

    @PostMapping
    @Operation(summary = "Crear un programa académico")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Programa creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    public ResponseEntity<ProgramaResponseDTO> crear(
            @Valid @RequestBody ProgramaRequestDTO request) {
        return ResponseEntity.ok(programaService.crear(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Editar un programa académico")
    public ResponseEntity<ProgramaResponseDTO> editar(
            @Parameter(description = "ID del programa") @PathVariable Long id,
            @Valid @RequestBody ProgramaRequestDTO request) {
        return ResponseEntity.ok(programaService.editar(id, request));
    }

    @GetMapping
    @Operation(summary = "Listar todos los programas")
    public ResponseEntity<List<ProgramaResponseDTO>> listar() {
        return ResponseEntity.ok(programaService.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un programa por su ID")
    public ResponseEntity<ProgramaResponseDTO> obtener(
            @Parameter(description = "ID del programa") @PathVariable Long id) {
        return ResponseEntity.ok(programaService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un programa por ID")
    public ResponseEntity<Void> eliminar(
            @Parameter(description = "ID del programa") @PathVariable Long id) {
        programaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
