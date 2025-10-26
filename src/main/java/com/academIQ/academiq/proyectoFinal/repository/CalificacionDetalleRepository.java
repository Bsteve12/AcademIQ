package com.academIQ.academiq.proyectoFinal.repository;

import com.academIQ.academiq.proyectoFinal.entity.CalificacionDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalificacionDetalleRepository extends JpaRepository<CalificacionDetalle, Long> {
    List<CalificacionDetalle> findByCalificacionId(Long calificacionId);
}
