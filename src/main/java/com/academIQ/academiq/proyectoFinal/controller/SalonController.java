package com.academIQ.academiq.proyectoFinal.controller;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.SalonRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.SalonResponseDTO;
import com.academIQ.academiq.proyectoFinal.services.salonService.interfaces.SalonServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Salones", description = "Gestión de salones y aulas")
@RestController
@RequestMapping("/api/salones")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class SalonController {

    private final SalonServiceInterface salonService;

    @PostMapping
    @Operation(summary = "Crear un salón")
    public ResponseEntity<SalonResponseDTO> crear(@Valid @RequestBody SalonRequestDTO dto) {
        return ResponseEntity.ok(salonService.crear(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Editar un salón")
    public ResponseEntity<SalonResponseDTO> editar(@PathVariable Long id, @Valid @RequestBody SalonRequestDTO dto) {
        return ResponseEntity.ok(salonService.editar(id, dto));
    }

    @GetMapping
    @Operation(summary = "Listar todos los salones")
    public ResponseEntity<List<SalonResponseDTO>> listar() {
        return ResponseEntity.ok(salonService.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener salón por ID")
    public ResponseEntity<SalonResponseDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(salonService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un salón")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        salonService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
