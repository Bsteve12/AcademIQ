package com.academIQ.academiq.proyectoFinal.services.usuarioService.implementation;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.UsuarioRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.UsuarioResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.Usuario;
import com.academIQ.academiq.proyectoFinal.mapper.UsuarioMapper;
import com.academIQ.academiq.proyectoFinal.repository.UsuarioRepository;
import com.academIQ.academiq.proyectoFinal.services.usuarioService.interfaces.UsuarioServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImplementation implements UsuarioServiceInterface {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UsuarioResponseDTO crear(UsuarioRequestDTO dto) {
        Usuario usuario = usuarioMapper.toEntity(dto);

        //  Encriptar la contraseña antes de guardar
        usuario.setPassword(passwordEncoder.encode(dto.getPassword()));

        usuarioRepository.save(usuario);
        return usuarioMapper.toResponseDTO(usuario);
    }

    @Override
    public UsuarioResponseDTO actualizar(Long id, UsuarioRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con ID: " + id));

        usuario.setNombreCompleto(dto.getNombreCompleto());
        usuario.setCorreo(dto.getCorreo());
        usuario.setRol(dto.getRol());
        usuario.setUsername(dto.getUsername());

        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            usuario.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        usuarioRepository.save(usuario);
        return usuarioMapper.toResponseDTO(usuario);
    }

    @Override
    public UsuarioResponseDTO obtenerPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con ID: " + id));

        return usuarioMapper.toResponseDTO(usuario);
    }

    @Override
    public List<UsuarioResponseDTO> listar() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminar(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con ID: " + id));

        usuarioRepository.delete(usuario);
    }

    //  En Oracle:
    // - Se deben manejar roles y privilegios con tablas y vistas específicas.
    // - Las contraseñas podrían almacenarse usando funciones de cifrado de Oracle (DBMS_CRYPTO).
    // - Podrían existir triggers para registrar en BITÁCORA los INSERT/UPDATE/DELETE sobre USUARIOS.
}
