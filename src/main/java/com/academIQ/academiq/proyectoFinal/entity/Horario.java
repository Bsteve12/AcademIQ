package com.academIQ.academiq.proyectoFinal.entity;

import com.academIQ.academiq.proyectoFinal.entity.enums.DiaSemana;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "horarios")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DiaSemana diaSemana; // Enum: LUNES, MARTES, etc.

    private LocalTime horaInicio;
    private LocalTime horaFin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grupo_id", nullable = false)
    private Grupo grupo;
}
