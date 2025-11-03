package com.academIQ.academiq.proyectoFinal.controller;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.DocenteRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.DocenteResponseDTO;
import com.academIQ.academiq.proyectoFinal.services.docenteService.interfaces.DocenteServiceInterface;
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

@Tag(name = "Docentes", description = "Operaciones para gestionar docentes")
@RestController
@RequestMapping("/api/docentes")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class DocenteController {

    private final DocenteServiceInterface docenteService;

    @PostMapping
    @Operation(summary = "Registrar un nuevo docente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Docente registrado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    public ResponseEntity<DocenteResponseDTO> crear(@Valid @RequestBody DocenteRequestDTO dto) {
        return ResponseEntity.ok(docenteService.crear(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Editar datos de un docente")
    public ResponseEntity<DocenteResponseDTO> editar(
            @Parameter(description = "ID del docente a editar") @PathVariable Long id,
            @Valid @RequestBody DocenteRequestDTO dto) {
        return ResponseEntity.ok(docenteService.editar(id, dto));
    }

    @GetMapping
    @Operation(summary = "Listar todos los docentes")
    public ResponseEntity<List<DocenteResponseDTO>> listar() {
        return ResponseEntity.ok(docenteService.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener docente por ID")
    public ResponseEntity<DocenteResponseDTO> obtener(
            @Parameter(description = "ID del docente") @PathVariable Long id) {
        return ResponseEntity.ok(docenteService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un docente por ID")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        docenteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
