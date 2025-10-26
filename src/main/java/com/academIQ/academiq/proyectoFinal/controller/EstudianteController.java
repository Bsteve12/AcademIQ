package com.academIQ.academiq.proyectoFinal.controller;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.EstudianteRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.EstudianteResponseDTO;
import com.academIQ.academiq.proyectoFinal.services.estudianteService.interfaces.EstudianteServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Estudiantes", description = "Operaciones para gestionar los estudiantes")
@RestController
@RequestMapping("/api/estudiantes")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class EstudianteController {

    private final EstudianteServiceInterface estudianteService;

    @PostMapping
    @Operation(summary = "Registrar un nuevo estudiante")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Estudiante registrado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos proporcionados")
    })
    public ResponseEntity<EstudianteResponseDTO> crear(
            @RequestBody EstudianteRequestDTO request) {
        return ResponseEntity.ok(estudianteService.crear(request));
    }

    @GetMapping
    @Operation(summary = "Listar todos los estudiantes")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de estudiantes obtenida correctamente")
    })
    public ResponseEntity<List<EstudianteResponseDTO>> listar() {
        return ResponseEntity.ok(estudianteService.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar estudiante por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Estudiante encontrado"),
            @ApiResponse(responseCode = "404", description = "Estudiante no encontrado")
    })
    public ResponseEntity<EstudianteResponseDTO> buscarPorId(
            @Parameter(description = "ID del estudiante a buscar") @PathVariable Long id) {
        return ResponseEntity.ok(estudianteService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar estudiante por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Estudiante eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Estudiante no encontrado")
    })
    public ResponseEntity<Void> eliminar(
            @Parameter(description = "ID del estudiante a eliminar") @PathVariable Long id) {
        estudianteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
