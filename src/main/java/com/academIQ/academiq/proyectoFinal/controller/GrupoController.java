package com.academIQ.academiq.proyectoFinal.controller;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.GrupoRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.GrupoResponseDTO;
import com.academIQ.academiq.proyectoFinal.services.grupoService.interfaces.GrupoServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Grupos", description = "Gestión de grupos académicos")
@RestController
@RequestMapping("/api/grupos")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class GrupoController {

    private final GrupoServiceInterface grupoService;

    @PostMapping
    @Operation(summary = "Crear un nuevo grupo")
    @ApiResponse(responseCode = "200", description = "Grupo creado correctamente")
    public ResponseEntity<GrupoResponseDTO> crear(@Valid @RequestBody GrupoRequestDTO dto) {
        return ResponseEntity.ok(grupoService.crear(dto));
    }

    @GetMapping
    @Operation(summary = "Listar todos los grupos")
    public ResponseEntity<List<GrupoResponseDTO>> listar() {
        return ResponseEntity.ok(grupoService.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar un grupo por ID")
    public ResponseEntity<GrupoResponseDTO> buscarPorId(
            @Parameter(description = "ID del grupo a buscar") @PathVariable Long id) {
        return ResponseEntity.ok(grupoService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un grupo por ID")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        grupoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
