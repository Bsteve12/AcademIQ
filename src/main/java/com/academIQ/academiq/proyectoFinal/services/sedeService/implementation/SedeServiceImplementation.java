package com.academIQ.academiq.proyectoFinal.services.sedeService.implementation;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.SedeRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.SedeResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.Sede;
import com.academIQ.academiq.proyectoFinal.mapper.SedeMapper;
import com.academIQ.academiq.proyectoFinal.repository.SedeRepository;
import com.academIQ.academiq.proyectoFinal.services.sedeService.interfaces.SedeServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SedeServiceImplementation implements SedeServiceInterface {

    private final SedeRepository sedeRepository;
    private final SedeMapper sedeMapper;

    @Override
    public SedeResponseDTO crear(SedeRequestDTO dto) {
        if (sedeRepository.existsByNombre(dto.getNombre())) {
            throw new IllegalArgumentException("Ya existe una sede con el nombre: " + dto.getNombre());
        }
        Sede sede = sedeMapper.toEntity(dto);
        sedeRepository.save(sede);
        return sedeMapper.toResponseDTO(sede);
    }

    @Override
    public List<SedeResponseDTO> listar() {
        return sedeRepository.findAll()
                .stream()
                .map(sedeMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SedeResponseDTO buscarPorId(Long id) {
        Sede sede = sedeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sede no encontrada con ID: " + id));
        return sedeMapper.toResponseDTO(sede);
    }

    @Override
    public void eliminar(Long id) {
        Sede sede = sedeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sede no encontrada con ID: " + id));
        sedeRepository.delete(sede);
    }
}
//                       EN ORCLE
//  Crear triggers para auditoría o bitácora de cambios de sede
//  Crear vistas para consultar sedes y número de programas asociados
//  Definir roles y privilegios de acceso a tablas "sedes"
