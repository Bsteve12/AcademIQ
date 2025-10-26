package com.academIQ.academiq.proyectoFinal.services.historialService.implementation;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.HistorialAcademicoRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.HistorialAcademicoResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.*;
import com.academIQ.academiq.proyectoFinal.mapper.HistorialAcademicoMapper;
import com.academIQ.academiq.proyectoFinal.repository.*;
import com.academIQ.academiq.proyectoFinal.services.historialService.interfaces.HistorialAcademicoServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HistorialAcademicoServiceImplementation implements HistorialAcademicoServiceInterface {

    private final HistorialAcademicoRepository historialRepository;
    private final EstudianteRepository estudianteRepository;
    private final AsignaturaRepository asignaturaRepository;
    private final PeriodoRepository periodoRepository;
    private final HistorialAcademicoMapper mapper;

    @Override
    public HistorialAcademicoResponseDTO registrar(HistorialAcademicoRequestDTO dto) {
        Estudiante estudiante = estudianteRepository.findById(dto.getEstudianteId())
                .orElseThrow(() -> new EntityNotFoundException("Estudiante no encontrado"));
        Asignatura asignatura = asignaturaRepository.findById(dto.getAsignaturaId())
                .orElseThrow(() -> new EntityNotFoundException("Asignatura no encontrada"));
        Periodo periodo = periodoRepository.findById(dto.getPeriodoId())
                .orElseThrow(() -> new EntityNotFoundException("Periodo no encontrado"));

        HistorialAcademico historial = mapper.toEntity(dto, estudiante, asignatura, periodo);

        //  Lógica que debe hacerse en ORACLE (comentario para profesor)
        // - Calcular automáticamente la notaFinal a partir de las calificaciones parciales.
        // - Determinar el resultado (APROBADO/REPROBADO) con procedimientos almacenados.
        // - Insertar el registro en tablas de auditoría si aplica.

        historialRepository.save(historial);
        return mapper.toResponseDTO(historial);
    }

    @Override
    public List<HistorialAcademicoResponseDTO> listar() {
        return historialRepository.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public HistorialAcademicoResponseDTO buscarPorId(Long id) {
        HistorialAcademico historial = historialRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Historial no encontrado"));
        return mapper.toResponseDTO(historial);
    }

    @Override
    public void eliminar(Long id) {
        HistorialAcademico historial = historialRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Historial no encontrado"));
        historialRepository.delete(historial);
    }
}
