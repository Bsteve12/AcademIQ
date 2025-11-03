package com.academIQ.academiq.proyectoFinal.services.salonService.implementation;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.SalonRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.SalonResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.Salon;
import com.academIQ.academiq.proyectoFinal.entity.Sede;
import com.academIQ.academiq.proyectoFinal.mapper.SalonMapper;
import com.academIQ.academiq.proyectoFinal.repository.SalonRepository;
import com.academIQ.academiq.proyectoFinal.repository.SedeRepository;
import com.academIQ.academiq.proyectoFinal.services.salonService.interfaces.SalonServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class SalonServiceImplementation implements SalonServiceInterface {

    private final SalonRepository salonRepository;
    private final SedeRepository sedeRepository;
    private final SalonMapper salonMapper;

    @Override
    public SalonResponseDTO crear(SalonRequestDTO dto) {
        // Validar existencia de la sede
        Sede sede = sedeRepository.findById(dto.getSedeId())
                .orElseThrow(() -> new EntityNotFoundException("Sede no encontrada con ID: " + dto.getSedeId()));

        // Validación: nombre único dentro de la misma sede
        if (salonRepository.existsByNombreAndSedeId(dto.getNombre(), dto.getSedeId())) {
            throw new IllegalArgumentException("Ya existe un salón con ese nombre en la sede indicada");
        }

        // Capacidad mínima ya validada por @Min en DTO, aquí validación extra por si hace falta
        if (dto.getCapacidad() <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser un número positivo");
        }

        Salon salon = salonMapper.toEntity(dto, sede);
        Salon guardado = salonRepository.save(salon);
        return salonMapper.toResponseDTO(guardado);
    }

    @Override
    public SalonResponseDTO editar(Long id, SalonRequestDTO dto) {
        Salon salon = salonRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Salón no encontrado con ID: " + id));

        // Si cambia nombre, validar unicidad en la misma sede
        if (!salon.getNombre().equals(dto.getNombre()) &&
                salonRepository.existsByNombreAndSedeId(dto.getNombre(), dto.getSedeId())) {
            throw new IllegalArgumentException("Ya existe un salón con ese nombre en la sede indicada");
        }

        Sede sede = sedeRepository.findById(dto.getSedeId())
                .orElseThrow(() -> new EntityNotFoundException("Sede no encontrada con ID: " + dto.getSedeId()));

        salon.setNombre(dto.getNombre());
        salon.setUbicacion(dto.getUbicacion());
        salon.setCapacidad(dto.getCapacidad());
        salon.setSede(sede);

        Salon actualizado = salonRepository.save(salon);
        return salonMapper.toResponseDTO(actualizado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SalonResponseDTO> listar() {
        return salonRepository.findAll()
                .stream()
                .map(salonMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public SalonResponseDTO buscarPorId(Long id) {
        Salon salon = salonRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Salón no encontrado con ID: " + id));
        return salonMapper.toResponseDTO(salon);
    }

    @Override
    public void eliminar(Long id) {
        Salon salon = salonRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Salón no encontrado con ID: " + id));
        // Nota: si hay dependencias (grupos, horarios) el delete puede fallar por FK; el DBA debe definir la política.
        salonRepository.delete(salon);
    }

    //  En Oracle (exclusivo) — lo que debe implementar el compañero de BD:
    // 1) Restricciones de integridad y FK: crear FK entre SALONES y SEDES, y FK desde GRUPOS/HORARIOS hacia SALONES.
    // 2) Triggers/procedimientos para verificar disponibilidad: evitar asignar dos grupos al mismo salón en el mismo horario.
    // 3) Vistas que indiquen ocupación por sede, salones disponibles en un periodo, etc.
    // 4) Políticas de eliminación: definir ON DELETE RESTRICT/CASCADE según reglas académicas (por ejemplo, no permitir borrar salón con grupos activos).
    // 5) Índices para consultas por sede/nombre si la data es grande.
}
