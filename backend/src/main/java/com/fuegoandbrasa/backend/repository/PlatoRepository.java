package com.fuegoandbrasa.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fuegoandbrasa.backend.model.Plato;

public interface PlatoRepository extends JpaRepository<Plato, Long>{
    
}
