package com.fuegoandbrasa.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fuegoandbrasa.backend.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
}
