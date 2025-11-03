package com.academIQ.academiq.proyectoFinal.services.programaService.implementation;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.ProgramaRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.ProgramaResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.Programa;
import com.academIQ.academiq.proyectoFinal.entity.Sede;
import com.academIQ.academiq.proyectoFinal.mapper.ProgramaMapper;
import com.academIQ.academiq.proyectoFinal.repository.ProgramaRepository;
import com.academIQ.academiq.proyectoFinal.repository.SedeRepository;
import com.academIQ.academiq.proyectoFinal.services.programaService.interfaces.ProgramaServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ProgramaServiceImplementation implements ProgramaServiceInterface {

    private final ProgramaRepository programaRepository;
    private final SedeRepository sedeRepository;
    private final ProgramaMapper programaMapper;

    /**
     * Crear un nuevo programa académico.
     */
    @Override
    public ProgramaResponseDTO crear(ProgramaRequestDTO dto) {
        // Validar duplicados
        if (programaRepository.existsByNombre(dto.getNombre())) {
            throw new IllegalArgumentException("Ya existe un programa con ese nombre");
        }

        // Buscar la sede a la que pertenece
        Sede sede = sedeRepository.findById(dto.getSedeId())
                .orElseThrow(() -> new EntityNotFoundException("No se encontró la sede con ID: " + dto.getSedeId()));

        Programa programa = programaMapper.toEntity(dto, sede);
        Programa guardado = programaRepository.save(programa);
        return programaMapper.toResponseDTO(guardado);
    }

    /**
     * Editar un programa existente.
     */
    @Override
    public ProgramaResponseDTO editar(Long id, ProgramaRequestDTO dto) {
        Programa programa = programaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Programa no encontrado con ID: " + id));

        // Buscar la sede actualizada
        Sede sede = sedeRepository.findById(dto.getSedeId())
                .orElseThrow(() -> new EntityNotFoundException("No se encontró la sede con ID: " + dto.getSedeId()));

        programa.setNombre(dto.getNombre());
        programa.setFacultad(dto.getFacultad());
        programa.setDuracionSemestres(dto.getDuracionSemestres());
        programa.setSede(sede);

        Programa actualizado = programaRepository.save(programa);
        return programaMapper.toResponseDTO(actualizado);
    }

    /**
     * Listar todos los programas registrados.
     */
    @Override
    @Transactional(readOnly = true)
    public List<ProgramaResponseDTO> listar() {
        return programaRepository.findAll()
                .stream()
                .map(programaMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    /**
     * Buscar un programa por su ID.
     */
    @Override
    @Transactional(readOnly = true)
    public ProgramaResponseDTO buscarPorId(Long id) {
        Programa programa = programaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Programa no encontrado con ID: " + id));
        return programaMapper.toResponseDTO(programa);
    }

    /**
     * Eliminar un programa.
     * En la práctica, podrías hacer un borrado lógico, pero aquí se hace físico.
     */
    @Override
    public void eliminar(Long id) {
        if (!programaRepository.existsById(id)) {
            throw new EntityNotFoundException("No se encontró el programa con ID: " + id);
        }
        programaRepository.deleteById(id);
    }

    // 🔸 En Oracle:
    // - Las relaciones entre Programa y Asignatura, Estudiante y Sede deben tener claves foráneas creadas manualmente en Oracle.
    // - La integridad referencial (ON DELETE CASCADE o restricciones de FK) se maneja allá, no aquí.
    // - Triggers de validación (por ejemplo, evitar eliminar un programa con estudiantes activos) deben crearse en Oracle.
    // - Vistas o funciones que calculen métricas como promedio de estudiantes por programa también van en Oracle.
    // - Procedimientos almacenados para reportes o consolidaciones también deben residir en Oracle.
}
