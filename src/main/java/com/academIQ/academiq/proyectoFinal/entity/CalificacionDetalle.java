package com.academIQ.academiq.proyectoFinal.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "calificaciones_detalle")
public class CalificacionDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double nota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evaluacion_item_id", nullable = false)
    private EvaluacionItem evaluacionItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "calificacion_id", nullable = false)
    private Calificacion calificacion;

    @Column(length = 255)
    private String descripcion;

}
