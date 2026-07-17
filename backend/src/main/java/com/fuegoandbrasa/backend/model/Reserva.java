package com.fuegoandbrasa.backend.model;

import java.time.*;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "reservas")
@Data
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "mesa_id")
    private Mesa mesa;

    private LocalDate fecha;
    private LocalTime hora;
    private Integer cantidadPersonas;
}
