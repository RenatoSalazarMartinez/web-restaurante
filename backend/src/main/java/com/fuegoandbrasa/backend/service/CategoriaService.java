package com.fuegoandbrasa.backend.service;

import com.fuegoandbrasa.backend.model.*;
import java.util.*;
import org.springframework.stereotype.Service;
import com.fuegoandbrasa.backend.repository.CategoriaRepository;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarCategorias(){
        return categoriaRepository.findAll();
    }

    public Categoria guardarCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public Categoria obtenerCategoriaPorId(Long id){
        return categoriaRepository.findById(id).
        orElseThrow(()-> new RuntimeException("Categoria no encontrada con el id: "+id));
    }

    public Categoria actualizarCategoria(Long id, Categoria categoriaActualizada){
        Categoria categoriaExistente = obtenerCategoriaPorId(id);
        categoriaExistente.setNombre(categoriaActualizada.getNombre());
        
        return categoriaRepository.save(categoriaExistente);
    }

    public void eliminarCategoria(Long id){
        categoriaRepository.deleteById(id);
    }
    
}
