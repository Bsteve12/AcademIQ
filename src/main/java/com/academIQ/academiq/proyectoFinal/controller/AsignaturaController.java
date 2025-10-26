package com.academIQ.academiq.proyectoFinal.controller;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.AsignaturaRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.AsignaturaResponseDTO;
import com.academIQ.academiq.proyectoFinal.services.asignaturaService.interfaces.AsignaturaServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Asignaturas", description = "Operaciones CRUD para gestión de asignaturas académicas")
@RestController
@RequestMapping("/api/asignaturas")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AsignaturaController {

    private final AsignaturaServiceInterface asignaturaService;

    @PostMapping
    @Operation(summary = "Crear una nueva asignatura")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Asignatura creada correctamente"),
            @ApiResponse(responseCode = "400", description = "Código duplicado o datos inválidos")
    })
    public ResponseEntity<AsignaturaResponseDTO> crear(@RequestBody AsignaturaRequestDTO dto) {
        return ResponseEntity.ok(asignaturaService.crear(dto));
    }

    @GetMapping
    @Operation(summary = "Listar todas las asignaturas")
    public ResponseEntity<List<AsignaturaResponseDTO>> listar() {
        return ResponseEntity.ok(asignaturaService.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar asignatura por ID")
    public ResponseEntity<AsignaturaResponseDTO> buscarPorId(
            @Parameter(description = "ID de la asignatura a buscar") @PathVariable Long id) {
        return ResponseEntity.ok(asignaturaService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una asignatura por ID")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        asignaturaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
