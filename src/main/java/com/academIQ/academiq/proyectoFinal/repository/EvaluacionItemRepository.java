package com.academIQ.academiq.proyectoFinal.repository;

import com.academIQ.academiq.proyectoFinal.entity.EvaluacionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluacionItemRepository extends JpaRepository<EvaluacionItem, Long> {
    List<EvaluacionItem> findByAsignaturaId(Long asignaturaId);
}
