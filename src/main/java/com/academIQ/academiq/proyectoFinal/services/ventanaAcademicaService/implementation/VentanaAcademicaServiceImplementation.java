package com.academIQ.academiq.proyectoFinal.services.ventanaAcademicaService.implementation;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.VentanaAcademicaRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.VentanaAcademicaResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.Periodo;
import com.academIQ.academiq.proyectoFinal.entity.VentanaAcademica;
import com.academIQ.academiq.proyectoFinal.mapper.VentanaAcademicaMapper;
import com.academIQ.academiq.proyectoFinal.repository.PeriodoRepository;
import com.academIQ.academiq.proyectoFinal.repository.VentanaAcademicaRepository;
import com.academIQ.academiq.proyectoFinal.services.ventanaAcademicaService.interfaces.VentanaAcademicaServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VentanaAcademicaServiceImplementation implements VentanaAcademicaServiceInterface {

    private final VentanaAcademicaRepository ventanaRepository;
    private final PeriodoRepository periodoRepository;
    private final VentanaAcademicaMapper mapper;

    @Override
    public VentanaAcademicaResponseDTO crear(VentanaAcademicaRequestDTO dto) {
        Periodo periodo = periodoRepository.findById(dto.getPeriodoId())
                .orElseThrow(() -> new EntityNotFoundException("Periodo no encontrado con ID: " + dto.getPeriodoId()));

        VentanaAcademica ventana = mapper.toEntity(dto, periodo);

        // 🔸 En Oracle se pueden implementar validaciones automáticas mediante triggers:
        // - Verificar que no existan ventanas solapadas para el mismo periodo.
        // - Controlar que las fechas estén dentro del rango del periodo.
        // Aquí solo hacemos validaciones básicas desde el backend.
        if (dto.getFechaInicioInscripcion().isAfter(dto.getFechaFinInscripcion()))
            throw new IllegalArgumentException("La fecha de inicio de inscripción no puede ser posterior a la de fin.");

        ventanaRepository.save(ventana);
        return mapper.toResponseDTO(ventana);
    }

    @Override
    public List<VentanaAcademicaResponseDTO> listar() {
        return ventanaRepository.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VentanaAcademicaResponseDTO buscarPorId(Long id) {
        VentanaAcademica ventana = ventanaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ventana académica no encontrada con ID: " + id));
        return mapper.toResponseDTO(ventana);
    }

    @Override
    public void eliminar(Long id) {
        ventanaRepository.deleteById(id);
    }
}
