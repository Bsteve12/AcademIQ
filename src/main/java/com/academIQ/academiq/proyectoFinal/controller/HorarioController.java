package com.academIQ.academiq.proyectoFinal.controller;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.HorarioRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.HorarioResponseDTO;
import com.academIQ.academiq.proyectoFinal.services.horarioService.interfaces.HorarioServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Horarios", description = "Operaciones para gestionar los horarios de los grupos")
@RestController
@RequestMapping("/api/horarios")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class HorarioController {

    private final HorarioServiceInterface horarioService;

    @PostMapping
    @Operation(summary = "Crear un horario para un grupo")
    public ResponseEntity<HorarioResponseDTO> crear(@RequestBody HorarioRequestDTO dto) {
        return ResponseEntity.ok(horarioService.crear(dto));
    }

    @GetMapping
    @Operation(summary = "Listar todos los horarios")
    public ResponseEntity<List<HorarioResponseDTO>> listar() {
        return ResponseEntity.ok(horarioService.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar horario por ID")
    public ResponseEntity<HorarioResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(horarioService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un horario")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        horarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
