package com.fuegoandbrasa.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fuegoandbrasa.backend.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
} 
