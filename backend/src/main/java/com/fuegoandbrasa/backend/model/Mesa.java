package com.fuegoandbrasa.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "mesas")
@Data
public class Mesa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private int numero;
    private int capacidad;

    @Enumerated(EnumType.STRING)
    private EstadoMesa estado;
}
