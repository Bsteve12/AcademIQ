package com.academIQ.academiq.proyectoFinal.services.prerrequisitoService.implementation;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.PrerrequisitoRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.PrerrequisitoResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.Asignatura;
import com.academIQ.academiq.proyectoFinal.entity.Prerrequisito;
import com.academIQ.academiq.proyectoFinal.mapper.PrerrequisitoMapper;
import com.academIQ.academiq.proyectoFinal.repository.AsignaturaRepository;
import com.academIQ.academiq.proyectoFinal.repository.PrerrequisitoRepository;
import com.academIQ.academiq.proyectoFinal.services.prerrequisitoService.interfaces.PrerrequisitoServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PrerrequisitoServiceImplementation implements PrerrequisitoServiceInterface {

    private final PrerrequisitoRepository prerrequisitoRepository;
    private final AsignaturaRepository asignaturaRepository;
    private final PrerrequisitoMapper mapper;

    @Override
    public PrerrequisitoResponseDTO crear(PrerrequisitoRequestDTO dto) {
        Asignatura asignatura = asignaturaRepository.findById(dto.getAsignaturaId())
                .orElseThrow(() -> new EntityNotFoundException("Asignatura no encontrada con ID: " + dto.getAsignaturaId()));

        Asignatura prereq = asignaturaRepository.findById(dto.getPrerrequisitoId())
                .orElseThrow(() -> new EntityNotFoundException("Prerrequisito no encontrado con ID: " + dto.getPrerrequisitoId()));

        // 🔸 Validaciones que pueden implementarse en Oracle mediante TRIGGERS:
        // - Evitar que una asignatura sea prerrequisito de sí misma.
        // - Evitar ciclos (una materia A no puede ser prerrequisito de B si B ya depende de A).
        // - Mantener integridad en cascada si una asignatura es eliminada.

        if (asignatura.getId().equals(prereq.getId())) {
            throw new IllegalArgumentException("Una asignatura no puede ser prerrequisito de sí misma.");
        }

        Prerrequisito prerrequisito = mapper.toEntity(dto, asignatura, prereq);
        prerrequisitoRepository.save(prerrequisito);

        return mapper.toResponseDTO(prerrequisito);
    }

    @Override
    public List<PrerrequisitoResponseDTO> listar() {
        return prerrequisitoRepository.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PrerrequisitoResponseDTO buscarPorId(Long id) {
        Prerrequisito entity = prerrequisitoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Prerrequisito no encontrado con ID: " + id));
        return mapper.toResponseDTO(entity);
    }

    @Override
    public void eliminar(Long id) {
        prerrequisitoRepository.deleteById(id);
    }
}
