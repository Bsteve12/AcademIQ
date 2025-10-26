package com.academIQ.academiq.proyectoFinal.controller;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.PrerrequisitoRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.PrerrequisitoResponseDTO;
import com.academIQ.academiq.proyectoFinal.services.prerrequisitoService.interfaces.PrerrequisitoServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Prerrequisitos", description = "Gestión de las relaciones de prerrequisitos entre asignaturas")
@RestController
@RequestMapping("/api/prerrequisitos")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class PrerrequisitoController {

    private final PrerrequisitoServiceInterface prerrequisitoService;

    @PostMapping
    @Operation(summary = "Registrar un prerrequisito para una asignatura")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Prerrequisito registrado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos o regla violada")
    })
    public ResponseEntity<PrerrequisitoResponseDTO> crear(@RequestBody PrerrequisitoRequestDTO dto) {
        return ResponseEntity.ok(prerrequisitoService.crear(dto));
    }

    @GetMapping
    @Operation(summary = "Listar todos los prerrequisitos")
    public ResponseEntity<List<PrerrequisitoResponseDTO>> listar() {
        return ResponseEntity.ok(prerrequisitoService.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar un prerrequisito por ID")
    public ResponseEntity<PrerrequisitoResponseDTO> buscarPorId(
            @Parameter(description = "ID del prerrequisito a buscar") @PathVariable Long id) {
        return ResponseEntity.ok(prerrequisitoService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un prerrequisito por ID")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        prerrequisitoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
