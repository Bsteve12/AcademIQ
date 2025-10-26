package com.academIQ.academiq.proyectoFinal.controller;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.SedeRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.SedeResponseDTO;
import com.academIQ.academiq.proyectoFinal.services.sedeService.interfaces.SedeServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Sedes", description = "Operaciones para la gestión de sedes académicas")
@RestController
@RequestMapping("/api/sedes")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class SedeController {

    private final SedeServiceInterface sedeService;

    @PostMapping
    @Operation(summary = "Registrar una nueva sede")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Sede creada correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos o sede duplicada")
    })
    public ResponseEntity<SedeResponseDTO> crear(@RequestBody SedeRequestDTO dto) {
        return ResponseEntity.ok(sedeService.crear(dto));
    }

    @GetMapping
    @Operation(summary = "Listar todas las sedes")
    public ResponseEntity<List<SedeResponseDTO>> listar() {
        return ResponseEntity.ok(sedeService.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar sede por ID")
    public ResponseEntity<SedeResponseDTO> buscarPorId(
            @Parameter(description = "ID de la sede a consultar") @PathVariable Long id) {
        return ResponseEntity.ok(sedeService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una sede por ID")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        sedeService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
