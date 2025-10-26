package com.academIQ.academiq.proyectoFinal.entity;

import com.academIQ.academiq.proyectoFinal.entity.enums.Rol;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private String nombreCompleto;
    private String correo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Rol rol; // Enum (ADMIN, DOCENTE, ESTUDIANTE)

    private boolean activo = true;
}
