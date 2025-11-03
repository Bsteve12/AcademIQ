package com.academIQ.academiq.proyectoFinal.services.docenteService.implementation;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.DocenteRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.DocenteResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.Asignatura;
import com.academIQ.academiq.proyectoFinal.entity.Docente;
import com.academIQ.academiq.proyectoFinal.mapper.DocenteMapper;
import com.academIQ.academiq.proyectoFinal.repository.AsignaturaRepository;
import com.academIQ.academiq.proyectoFinal.repository.DocenteRepository;
import com.academIQ.academiq.proyectoFinal.services.docenteService.interfaces.DocenteServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class DocenteServiceImplementation implements DocenteServiceInterface {

    private final DocenteRepository docenteRepository;
    private final AsignaturaRepository asignaturaRepository;
    private final DocenteMapper docenteMapper;

    @Override
    public DocenteResponseDTO crear(DocenteRequestDTO dto) {
        // Validación de correo único
        if (docenteRepository.existsByCorreo(dto.getCorreo())) {
            throw new IllegalArgumentException("Ya existe un docente con ese correo: " + dto.getCorreo());
        }

        // Resolver las asignaturas (si se enviaron IDs)
        List<Asignatura> asignaturas = Collections.emptyList();
        if (dto.getAsignaturaIds() != null && !dto.getAsignaturaIds().isEmpty()) {
            asignaturas = asignaturaRepository.findAllById(dto.getAsignaturaIds());

            // Validación: todos los IDs existen
            if (asignaturas.size() != dto.getAsignaturaIds().size()) {
                // Encontrar cuáles faltan (opcional)
                List<Long> encontrados = asignaturas.stream().map(Asignatura::getId).collect(Collectors.toList());
                List<Long> faltantes = dto.getAsignaturaIds().stream()
                        .filter(id -> !encontrados.contains(id))
                        .collect(Collectors.toList());
                throw new EntityNotFoundException("No se encontraron las asignaturas con IDs: " + faltantes);
            }
        }

        Docente docente = docenteMapper.toEntity(dto, asignaturas);
        Docente guardado = docenteRepository.save(docente);
        return docenteMapper.toResponseDTO(guardado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DocenteResponseDTO> listar() {
        return docenteRepository.findAll()
                .stream()
                .map(docenteMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public DocenteResponseDTO buscarPorId(Long id) {
        Docente docente = docenteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Docente no encontrado con ID: " + id));
        return docenteMapper.toResponseDTO(docente);
    }

    @Override
    public DocenteResponseDTO editar(Long id, DocenteRequestDTO dto) {
        Docente docente = docenteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Docente no encontrado con ID: " + id));

        // Si actualizan correo, validar unicidad
        if (!docente.getCorreo().equals(dto.getCorreo()) && docenteRepository.existsByCorreo(dto.getCorreo())) {
            throw new IllegalArgumentException("Otro docente ya usa el correo: " + dto.getCorreo());
        }

        // Resolver asignaturas (si se envían)
        List<Asignatura> asignaturas = Collections.emptyList();
        if (dto.getAsignaturaIds() != null && !dto.getAsignaturaIds().isEmpty()) {
            asignaturas = asignaturaRepository.findAllById(dto.getAsignaturaIds());
            if (asignaturas.size() != dto.getAsignaturaIds().size()) {
                List<Long> encontrados = asignaturas.stream().map(Asignatura::getId).collect(Collectors.toList());
                List<Long> faltantes = dto.getAsignaturaIds().stream()
                        .filter(i -> !encontrados.contains(i))
                        .collect(Collectors.toList());
                throw new EntityNotFoundException("No se encontraron las asignaturas con IDs: " + faltantes);
            }
        }

        docente.setNombre(dto.getNombre());
        docente.setCorreo(dto.getCorreo());
        docente.setTelefono(dto.getTelefono());
        docente.setEspecialidad(dto.getEspecialidad());
        docente.setAsignaturas(asignaturas);

        Docente actualizado = docenteRepository.save(docente);
        return docenteMapper.toResponseDTO(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        Docente docente = docenteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Docente no encontrado con ID: " + id));
        docenteRepository.delete(docente);
    }

    //  En Oracle:
    // - La tabla intermedia docente_asignatura (relación N:M) debe existir físicamente con FK hacia docentes y asignaturas.
    // - Reglas de negocio avanzadas (por ejemplo: evitar asignar un docente a dos grupos con choque de horario) deben implementarse con procedimientos/triggers en Oracle o mediante vistas que permitan detectar conflictos.
    // - Vistas y reportes (docentes por sede, carga académica por docente, número de grupos por docente) se implementan en Oracle.
    // - Control de privilegios/roles sobre las tablas (quién puede insertar/actualizar/eliminar) se define en Oracle.
}
