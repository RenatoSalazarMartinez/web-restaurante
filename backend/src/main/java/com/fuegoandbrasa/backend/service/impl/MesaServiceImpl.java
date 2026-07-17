package com.fuegoandbrasa.backend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.fuegoandbrasa.backend.model.*;
import com.fuegoandbrasa.backend.repository.MesaRepository;
import com.fuegoandbrasa.backend.service.MesaService;

@Service
@RequiredArgsConstructor //Generará un constructor con los campos que marquemos como final
public class MesaServiceImpl implements MesaService{
    private final MesaRepository mesaRepository;

    @Override
    public List<Mesa> listarMesas() {
        return mesaRepository.findAll();
    }

    @Override
    public Mesa buscarPorId(Long id) {
        return mesaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Mesa no encontrada con el ID: "+id));
    }

    @Override
    public List<Mesa> buscarPorEstado(EstadoMesa estado) {
        return mesaRepository.findByEstado(estado);
    }

    @Override
    public Mesa guardarMesa(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    @Override
    public Mesa actualizarEstado(Long id, EstadoMesa nuevoEstado) {
        Mesa mesaEncontrada = buscarPorId(id);
        mesaEncontrada.setEstado(nuevoEstado);
        return mesaRepository.save(mesaEncontrada);
    }
}
