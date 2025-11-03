package com.academIQ.academiq.proyectoFinal.controller;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.HistorialAcademicoRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.HistorialAcademicoResponseDTO;
import com.academIQ.academiq.proyectoFinal.services.historialService.interfaces.HistorialAcademicoServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Historial Académico", description = "Operaciones para gestionar el historial académico de los estudiantes")
@RestController
@RequestMapping("/api/historial-academico")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class HistorialAcademicoController {

    private final HistorialAcademicoServiceInterface historialService;

    @PostMapping
    @Operation(summary = "Registrar un nuevo historial académico")
    public ResponseEntity<HistorialAcademicoResponseDTO> registrar(@RequestBody HistorialAcademicoRequestDTO dto) {
        return ResponseEntity.ok(historialService.registrar(dto));
    }

    @GetMapping
    @Operation(summary = "Listar todos los registros de historial académico")
    public ResponseEntity<List<HistorialAcademicoResponseDTO>> listar() {
        return ResponseEntity.ok(historialService.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar un historial académico por ID")
    public ResponseEntity<HistorialAcademicoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(historialService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un registro del historial académico")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        historialService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
