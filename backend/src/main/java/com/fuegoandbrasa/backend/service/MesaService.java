package com.fuegoandbrasa.backend.service;

import java.util.List;
import com.fuegoandbrasa.backend.model.EstadoMesa;
import com.fuegoandbrasa.backend.model.Mesa;

public interface MesaService {

    List<Mesa> listarMesas();

    Mesa buscarPorId(Long id);

    List<Mesa> buscarPorEstado(EstadoMesa estado);
    
    Mesa guardarMesa(Mesa mesa);

    Mesa actualizarEstado(Long id, EstadoMesa nuevoEstado);
}
