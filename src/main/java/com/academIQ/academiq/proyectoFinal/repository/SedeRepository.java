package com.academIQ.academiq.proyectoFinal.repository;

import com.academIQ.academiq.proyectoFinal.entity.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SedeRepository extends JpaRepository<Sede, Long> {
    boolean existsByNombre(String nombre);
}
