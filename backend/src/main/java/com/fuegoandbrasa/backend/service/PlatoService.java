package com.fuegoandbrasa.backend.service;


import com.fuegoandbrasa.backend.model.Plato;
import com.fuegoandbrasa.backend.repository.PlatoRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PlatoService {
    private final PlatoRepository platoRepository;

    // El constructor permite que Spring Boot inyecte el repositorio automáticamente
    public PlatoService(PlatoRepository platoRepository) {
        this.platoRepository = platoRepository;
    }

    public List<Plato> listarPlatos(){
        return platoRepository.findAll(); //Trae todo los registros en forma de lista
    }

    public Plato guardarPlato(Plato plato){
        return platoRepository.save(plato);
    }

}
