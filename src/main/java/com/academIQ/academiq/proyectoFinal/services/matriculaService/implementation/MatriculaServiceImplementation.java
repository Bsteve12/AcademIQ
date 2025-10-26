package com.academIQ.academiq.proyectoFinal.services.matriculaService.implementation;

import com.academIQ.academiq.proyectoFinal.dto.inputDTO.MatriculaRequestDTO;
import com.academIQ.academiq.proyectoFinal.dto.outputDTO.MatriculaResponseDTO;
import com.academIQ.academiq.proyectoFinal.entity.*;
import com.academIQ.academiq.proyectoFinal.mapper.MatriculaMapper;
import com.academIQ.academiq.proyectoFinal.repository.*;
import com.academIQ.academiq.proyectoFinal.services.matriculaService.interfaces.MatriculaServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class MatriculaServiceImplementation implements MatriculaServiceInterface {

    private final MatriculaRepository matriculaRepository;
    private final EstudianteRepository estudianteRepository;
    private final AsignaturaRepository asignaturaRepository;
    private final PeriodoRepository periodoRepository;
    private final GrupoRepository grupoRepository; // opcional si decides matricular por grupo
    private final MatriculaMapper matriculaMapper;

    /**
     * Crear matrícula (BACKEND):
     * - Validaciones básicas y existencia de entidades relacionadas.
     * - Prevención local de duplicados (estudiante+asignatura+periodo).
     * - Envío a persistencia JPA.
     *
     * Reglas complejas y chequeos transaccionales críticos (CUPOS, HORARIOS, PRERREQUISITOS, AUDITORÍA)
     * deben implementarse en Oracle (ver comentarios más abajo).
     */
    @Override
    public MatriculaResponseDTO crear(MatriculaRequestDTO dto) {
        Estudiante estudiante = estudianteRepository.findById(dto.getEstudianteId())
                .orElseThrow(() -> new EntityNotFoundException("Estudiante no encontrado con ID: " + dto.getEstudianteId()));

        Asignatura asignatura = asignaturaRepository.findById(dto.getAsignaturaId())
                .orElseThrow(() -> new EntityNotFoundException("Asignatura no encontrada con ID: " + dto.getAsignaturaId()));

        Periodo periodo = periodoRepository.findById(dto.getPeriodoId())
                .orElseThrow(() -> new EntityNotFoundException("Periodo no encontrado con ID: " + dto.getPeriodoId()));

        // Validación básica en el backend para evitar duplicados inmediatos
        if (matriculaRepository.existsByEstudianteIdAndAsignaturaIdAndPeriodoId(
                dto.getEstudianteId(), dto.getAsignaturaId(), dto.getPeriodoId())) {
            throw new IllegalArgumentException("El estudiante ya está matriculado en esta asignatura para el mismo periodo.");
        }

        // OPCIONAL: Si en tu modelo quieres ligar matrícula a un Grupo específico,
        // agrega grupoId en MatriculaRequestDTO y valida aquí:
        // Grupo grupo = grupoRepository.findById(dto.getGrupoId()).orElseThrow(...);
        // y luego pasar el grupo al mapper/entidad.

        //  En Oracle: VALIDACIONES/ACCIONES EXCLUSIVAS (NO implementar solo en Java)
        // 1) Integridad referencial: claves foráneas entre MATRICULAS y ESTUDIANTES, ASIGNATURAS, PERIODOS (y GRUPOS si aplica).
        // 2) Trigger/Procedure de control de CUPOS:
        //    - Antes de insertar en MATRICULAS, verificar que el grupo (o el cupo de la asignatura) tenga cupo_actual < cupo_maximo.
        //    - Si se supera el cupo, impedir la inserción y devolver mensaje controlado.
        //    - Si el DBA implementa un procedimiento para matricular (p. ej. SP_REGISTRAR_MATRICULA), el backend debe llamar a ese procedimiento en lugar
        //      de hacer insert directo (para que la operación sea atómica en BD).
        // 3) Triggers para validar PRERREQUISITOS:
        //    - Verificar que el estudiante cumpla prerrequisitos en tablas PRERREQUISITO (implementadas en Oracle).
        // 4) Validación de conflictos de HORARIO:
        //    - Verificar que el estudiante no tenga otra matrícula con horario que choque (se detecta vía consultas a las tablas HORARIOS/GRUPOS).
        // 5) Auditoría y bitácora:
        //    - Triggers que registren en BITACORA quién y cuándo creó/ eliminó/ modificó una matrícula.
        // 6) Procedimiento para actualizar CUPO_ACTUAL de GRUPOS:
        //    - Si la matrícula afecta el cupo de un grupo, actualizar cupo_actual dentro del mismo procedimiento transaccional.
        // 7) Reglas de negocio sensibles:
        //    - Rechazar matrícula si el estudiante supera carga máxima de créditos — esto se valida más fiable en BD con procedimientos.
        // 8) Roles y permisos:
        //    - Definir qué roles (DB users) pueden ejecutar ciertos procedimientos o hacer DML sobre MATRICULAS.
        //
        // Resumen: el backend puede y debe validar existencia y duplicados, pero **las reglas transaccionales críticas y la coherencia
        // multi-tabla deben implementarse en Oracle** para garantizar atomicidad, rendimiento y cumplimiento con lo que pide el profesor.

        Matricula matricula = matriculaMapper.toEntity(dto, estudiante, asignatura, periodo);
        Matricula guardada = matriculaRepository.save(matricula);

        // NOTA: si el DBA creó procedimientos que actualizan cupo_actual, se esperaría que el insert/disparo en BD
        // actualice cupo_actual; en desarrollo con hibernate este campo quedará en 0 hasta que se invoque la lógica en BD.

        return matriculaMapper.toResponseDTO(guardada);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MatriculaResponseDTO> listar() {
        return matriculaRepository.findAll()
                .stream()
                .map(matriculaMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public MatriculaResponseDTO buscarPorId(Long id) {
        Matricula matricula = matriculaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Matrícula no encontrada con ID: " + id));
        return matriculaMapper.toResponseDTO(matricula);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MatriculaResponseDTO> listarPorEstudiante(Long estudianteId) {
        return matriculaRepository.findByEstudianteId(estudianteId)
                .stream()
                .map(matriculaMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminar(Long id) {
        Matricula matricula = matriculaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Matrícula no encontrada con ID: " + id));

        //  En Oracle: el DBA debe definir política de eliminación:
        //    - Si se elimina una matrícula, ¿se decrementa automáticamente cupo_actual del grupo? (procedimiento/trigger)
        //    - ¿Se permite eliminar matrículas activas o debe cambiarse estado a 'Retirada'?
        // El backend aquí hace delete físico, pero en producción lo ideal es invocar procedimiento de anulacion que aplique todas las reglas.

        matriculaRepository.delete(matricula);
    }
}
