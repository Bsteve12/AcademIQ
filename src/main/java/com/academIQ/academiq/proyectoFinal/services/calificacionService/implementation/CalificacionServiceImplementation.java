package com.academIQ.academiq.proyectoFinal.services.calificacionService.implementation;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.CalificacionRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.CalificacionResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.Calificacion;
import com.academIQ.academiq.proyectoFinal.entity.Matricula;
import com.academIQ.academiq.proyectoFinal.mapper.CalificacionMapper;
import com.academIQ.academiq.proyectoFinal.repository.CalificacionRepository;
import com.academIQ.academiq.proyectoFinal.repository.MatriculaRepository;
import com.academIQ.academiq.proyectoFinal.services.calificacionService.interfaces.CalificacionServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CalificacionServiceImplementation implements CalificacionServiceInterface {

    private final CalificacionRepository calificacionRepository;
    private final MatriculaRepository matriculaRepository;
    private final CalificacionMapper calificacionMapper;

    @Override
    public CalificacionResponseDTO crear(CalificacionRequestDTO dto) {
        Matricula matricula = matriculaRepository.findById(dto.getMatriculaId())
                .orElseThrow(() -> new EntityNotFoundException("Matrícula no encontrada con ID: " + dto.getMatriculaId()));

        if (calificacionRepository.existsByMatriculaId(dto.getMatriculaId())) {
            throw new IllegalArgumentException("La matrícula ya tiene una calificación asociada.");
        }

        Calificacion calificacion = calificacionMapper.toEntity(dto, matricula);

        //  En Oracle:
        // - Implementar trigger o procedimiento para calcular nota_final automáticamente:
        //     UPDATE CALIFICACIONES
        //     SET NOTA_FINAL = ROUND((NOTA1 + NOTA2 + NOTA3) / 3, 2)
        //     WHERE ID = :NEW.ID;
        //
        // - También puede hacerse mediante un PROCEDURE (p.ej. SP_REGISTRAR_CALIFICACION)
        //   que reciba las 3 notas, calcule nota_final y guarde en la tabla.
        // - Triggers de BITÁCORA para registrar cambios de calificaciones (quién y cuándo).

        // Cálculo provisional (solo a nivel backend)
        Double notaFinal = (dto.getNota1() + dto.getNota2() + dto.getNota3()) / 3;
        calificacion.setNotaFinal(Math.round(notaFinal * 100.0) / 100.0);

        calificacionRepository.save(calificacion);
        return calificacionMapper.toResponseDTO(calificacion);
    }

    @Override
    public CalificacionResponseDTO actualizar(Long id, CalificacionRequestDTO dto) {
        Calificacion calificacion = calificacionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Calificación no encontrada con ID: " + id));

        calificacion.setNota1(dto.getNota1());
        calificacion.setNota2(dto.getNota2());
        calificacion.setNota3(dto.getNota3());

        //  En Oracle:
        // Trigger AFTER UPDATE recalcula nota_final automáticamente.
        Double notaFinal = (dto.getNota1() + dto.getNota2() + dto.getNota3()) / 3;
        calificacion.setNotaFinal(Math.round(notaFinal * 100.0) / 100.0);

        return calificacionMapper.toResponseDTO(calificacionRepository.save(calificacion));
    }

    @Override
    @Transactional(readOnly = true)
    public CalificacionResponseDTO buscarPorId(Long id) {
        Calificacion calificacion = calificacionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Calificación no encontrada con ID: " + id));
        return calificacionMapper.toResponseDTO(calificacion);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CalificacionResponseDTO> listar() {
        return calificacionRepository.findAll()
                .stream()
                .map(calificacionMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminar(Long id) {
        Calificacion calificacion = calificacionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Calificación no encontrada con ID: " + id));

        // En Oracle:
        // - Definir si al eliminar una calificación se borra o solo se inactiva.
        // - Registrar en BITÁCORA los cambios de calificaciones.
        calificacionRepository.delete(calificacion);
    }
}
