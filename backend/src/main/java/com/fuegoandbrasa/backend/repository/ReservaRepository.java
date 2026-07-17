package com.fuegoandbrasa.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fuegoandbrasa.backend.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{
    
}
