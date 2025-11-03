package com.academIQ.academiq.proyectoFinal.services.horarioService.implementation;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.HorarioRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.HorarioResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.Grupo;
import com.academIQ.academiq.proyectoFinal.entity.Horario;
import com.academIQ.academiq.proyectoFinal.mapper.HorarioMapper;
import com.academIQ.academiq.proyectoFinal.repository.GrupoRepository;
import com.academIQ.academiq.proyectoFinal.repository.HorarioRepository;
import com.academIQ.academiq.proyectoFinal.services.horarioService.interfaces.HorarioServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HorarioServiceImplementation implements HorarioServiceInterface {

    private final HorarioRepository horarioRepository;
    private final GrupoRepository grupoRepository;
    private final HorarioMapper mapper;

    @Override
    public HorarioResponseDTO crear(HorarioRequestDTO dto) {
        Grupo grupo = grupoRepository.findById(dto.getGrupoId())
                .orElseThrow(() -> new EntityNotFoundException("Grupo no encontrado"));

        //  Lógica posible en Java:
        // - Validar que horaInicio < horaFin
        // - Validar que el horario no se solape con otros del mismo grupo

        //  Lógica que debe implementarse en ORACLE:
        // - Validar conflictos de horario entre grupos del mismo estudiante (reglas globales).
        // - Registrar automáticamente cambios en BITÁCORA.
        // - Actualizar disponibilidad de salones.

        Horario horario = mapper.toEntity(dto, grupo);
        horarioRepository.save(horario);
        return mapper.toResponseDTO(horario);
    }

    @Override
    public List<HorarioResponseDTO> listar() {
        return horarioRepository.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public HorarioResponseDTO buscarPorId(Long id) {
        Horario horario = horarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Horario no encontrado"));
        return mapper.toResponseDTO(horario);
    }

    @Override
    public void eliminar(Long id) {
        Horario horario = horarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Horario no encontrado"));
        horarioRepository.delete(horario);
    }
}
