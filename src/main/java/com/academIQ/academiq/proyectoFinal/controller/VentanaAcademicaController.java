package com.academIQ.academiq.proyectoFinal.controller;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.VentanaAcademicaRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.VentanaAcademicaResponseDTO;
import com.academIQ.academiq.proyectoFinal.services.ventanaAcademicaService.interfaces.VentanaAcademicaServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Ventanas Académicas", description = "Gestión de fechas de inscripción y retiro académico")
@RestController
@RequestMapping("/api/ventanas-academicas")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class VentanaAcademicaController {

    private final VentanaAcademicaServiceInterface ventanaService;

    @PostMapping
    @Operation(summary = "Crear una nueva ventana académica")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ventana creada correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    public ResponseEntity<VentanaAcademicaResponseDTO> crear(
            @RequestBody VentanaAcademicaRequestDTO dto) {
        return ResponseEntity.ok(ventanaService.crear(dto));
    }

    @GetMapping
    @Operation(summary = "Listar todas las ventanas académicas")
    public ResponseEntity<List<VentanaAcademicaResponseDTO>> listar() {
        return ResponseEntity.ok(ventanaService.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar ventana académica por ID")
    public ResponseEntity<VentanaAcademicaResponseDTO> buscarPorId(
            @Parameter(description = "ID de la ventana académica") @PathVariable Long id) {
        return ResponseEntity.ok(ventanaService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar ventana académica por ID")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        ventanaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
