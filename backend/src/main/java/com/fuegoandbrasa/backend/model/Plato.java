package com.fuegoandbrasa.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "platos")
@Data
public class Plato {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
}
