package com.academIQ.academiq.proyectoFinal.controller;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.BitacoraRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.BitacoraResponseDTO;
import com.academIQ.academiq.proyectoFinal.services.bitacoraService.interfaces.BitacoraServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Bitácora", description = "Operaciones para registrar y consultar las acciones del sistema")
@RestController
@RequestMapping("/api/bitacora")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class BitacoraController {

    private final BitacoraServiceInterface bitacoraService;

    @PostMapping
    @Operation(summary = "Registrar una acción en la bitácora")
    @ApiResponse(responseCode = "200", description = "Acción registrada correctamente")
    public ResponseEntity<BitacoraResponseDTO> registrar(@RequestBody BitacoraRequestDTO dto) {
        return ResponseEntity.ok(bitacoraService.registrar(dto));
    }

    @GetMapping
    @Operation(summary = "Listar todos los registros de la bitácora")
    @ApiResponse(responseCode = "200", description = "Registros obtenidos correctamente")
    public ResponseEntity<List<BitacoraResponseDTO>> listar() {
        return ResponseEntity.ok(bitacoraService.listar());
    }
}
