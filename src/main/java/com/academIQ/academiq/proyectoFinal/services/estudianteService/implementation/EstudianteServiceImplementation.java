package com.academIQ.academiq.proyectoFinal.services.estudianteService.implementation;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.EstudianteRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.EstudianteResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.Estudiante;
import com.academIQ.academiq.proyectoFinal.entity.Programa;
import com.academIQ.academiq.proyectoFinal.mapper.EstudianteMapper;
import com.academIQ.academiq.proyectoFinal.repository.EstudianteRepository;
import com.academIQ.academiq.proyectoFinal.repository.ProgramaRepository;
import com.academIQ.academiq.proyectoFinal.services.estudianteService.interfaces.EstudianteServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImplementation implements EstudianteServiceInterface {

    private final EstudianteRepository estudianteRepository;
    private final ProgramaRepository programaRepository;
    private final EstudianteMapper estudianteMapper;

    @Override
    public EstudianteResponseDTO crear(EstudianteRequestDTO dto) {
        Programa programa = programaRepository.findById(dto.getProgramaId())
                .orElseThrow(() -> new EntityNotFoundException("Programa no encontrado con ID: " + dto.getProgramaId()));

        Estudiante estudiante = estudianteMapper.toEntity(dto, programa);
        estudianteRepository.save(estudiante);

        return estudianteMapper.toResponseDTO(estudiante);
    }

    @Override
    public List<EstudianteResponseDTO> listar() {
        return estudianteRepository.findAll()
                .stream()
                .map(estudianteMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EstudianteResponseDTO buscarPorId(Long id) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Estudiante no encontrado con ID: " + id));

        return estudianteMapper.toResponseDTO(estudiante);
    }

    @Override
    public void eliminar(Long id) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Estudiante no encontrado con ID: " + id));

        estudianteRepository.delete(estudiante);
    }
}
