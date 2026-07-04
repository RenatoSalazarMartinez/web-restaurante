package com.fuegoandbrasa.backend.service;


import com.fuegoandbrasa.backend.model.*;
import com.fuegoandbrasa.backend.repository.CategoriaRepository;
import com.fuegoandbrasa.backend.repository.PlatoRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PlatoService {
    private final PlatoRepository platoRepository;
    private final CategoriaRepository categoriaRepository;

    // El constructor permite que Spring Boot inyecte el repositorio automáticamente
    public PlatoService(PlatoRepository platoRepository, CategoriaRepository categoriaRepository) {
        this.platoRepository = platoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<Plato> listarPlatos(){
        return platoRepository.findAll(); //Trae todo los registros en forma de lista
    }

    public Plato guardarPlato(Plato plato){
        Long categoriaId = plato.getCategoria().getId();
        Categoria categoriaEncontrada = categoriaRepository.findById(categoriaId)
            .orElseThrow(() -> new RuntimeException("Categoria no encontrada con el ID: "+categoriaId));

        plato.setCategoria(categoriaEncontrada);

        return platoRepository.save(plato);
    }

    public Plato obtenerPlatoPorId(Long id){
        return platoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Plato no encontrado con el id: "+id));
    }

    public Plato actualizarPlato(Long id, Plato platoActualizado){
        Plato platoExistente = obtenerPlatoPorId(id);
        Long categoriaId = platoActualizado.getCategoria().getId();
        Categoria categoriaEncontrada = categoriaRepository.findById(categoriaId).
            orElseThrow(()-> new RuntimeException("Categoria no encontrada con el ID: "+categoriaId));     

        platoExistente.setNombre(platoActualizado.getNombre());
        platoExistente.setPrecio(platoActualizado.getPrecio());
        platoExistente.setDescripcion(platoActualizado.getDescripcion());
        platoExistente.setCategoria(categoriaEncontrada);

        return platoRepository.save(platoExistente);
    }

    public void eliminarPlato(Long id){
        platoRepository.deleteById(id);
    }
}
