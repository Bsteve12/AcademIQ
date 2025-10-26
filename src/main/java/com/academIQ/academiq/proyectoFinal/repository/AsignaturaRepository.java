package com.academIQ.academiq.proyectoFinal.repository;

import com.academIQ.academiq.proyectoFinal.entity.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
    boolean existsByCodigo(String codigo);
}
