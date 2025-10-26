package com.academIQ.academiq.proyectoFinal.repository;

import com.academIQ.academiq.proyectoFinal.entity.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalonRepository extends JpaRepository<Salon, Long> {
    Optional<Salon> findByNombreAndSedeId(String nombre, Long sedeId);
    boolean existsByNombreAndSedeId(String nombre, Long sedeId);
}
