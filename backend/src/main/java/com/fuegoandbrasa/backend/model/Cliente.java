package com.fuegoandbrasa.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "clientes")
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCompleto;
    private String telefono;
    private String correoElectronico;
}
