package com.academIQ.academiq.proyectoFinal.services.bitacoraService.implementation;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.BitacoraRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.BitacoraResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.Bitacora;
import com.academIQ.academiq.proyectoFinal.entity.Usuario;
import com.academIQ.academiq.proyectoFinal.mapper.BitacoraMapper;
import com.academIQ.academiq.proyectoFinal.repository.BitacoraRepository;
import com.academIQ.academiq.proyectoFinal.repository.UsuarioRepository;
import com.academIQ.academiq.proyectoFinal.services.bitacoraService.interfaces.BitacoraServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BitacoraServiceImplementation implements BitacoraServiceInterface {

    private final BitacoraRepository bitacoraRepository;
    private final UsuarioRepository usuarioRepository;
    private final BitacoraMapper bitacoraMapper;

    @Override
    public BitacoraResponseDTO registrar(BitacoraRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con ID: " + dto.getUsuarioId()));

        Bitacora bitacora = bitacoraMapper.toEntity(dto, usuario);
        bitacoraRepository.save(bitacora);

        return bitacoraMapper.toResponseDTO(bitacora);
    }

    @Override
    public List<BitacoraResponseDTO> listar() {
        return bitacoraRepository.findAll()
                .stream()
                .map(bitacoraMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    //  En Oracle:
    // Se deben crear TRIGGERS para registrar automáticamente en la bitácora
    // acciones como INSERT, UPDATE o DELETE sobre las tablas principales
    // (por ejemplo, sobre ESTUDIANTE, MATRICULA, CALIFICACION, etc.).
    // Estos triggers insertan registros en la tabla BITACORA con usuario, acción y timestamp.
}
