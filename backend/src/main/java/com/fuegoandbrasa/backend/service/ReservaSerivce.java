package com.fuegoandbrasa.backend.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.fuegoandbrasa.backend.exceptions.ValidacionException;
import com.fuegoandbrasa.backend.model.*;
import com.fuegoandbrasa.backend.repository.ReservaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservaSerivce {
    private final ReservaRepository reservaRepository;
    private final ClienteService clienteService;
    private final MesaService mesaService;

    public List<Reserva> listarReservas(){
        return reservaRepository.findAll();
    }

    public Reserva guardarReserva(Reserva reserva){
        Cliente clienteExistente = clienteService.buscarClientePorId(reserva.getCliente().getId());
        Mesa mesaExistente = mesaService.buscarPorId(reserva.getMesa().getId());

        if (reserva.getCantidadPersonas() > mesaExistente.getCapacidad()) {
            throw new ValidacionException("La cantidad de personas excede la capacidad máxima de la mesa.");
        } else if (mesaExistente.getEstado() != EstadoMesa.LIBRE){
            throw new ValidacionException("La mesa seleccionada no está disponible para reservarse.");
        } else {
            mesaExistente.setEstado(EstadoMesa.RESERVADA);
            mesaService.actualizarEstado(mesaExistente.getId(), EstadoMesa.RESERVADA);

            reserva.setCliente(clienteExistente);
            reserva.setMesa(mesaExistente);
            return reservaRepository.save(reserva);
        }
    }

    public Reserva buscarReservaPorId(Long id){
        return reservaRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("No se encontró la reserva con el ID:"+id));
    }

    public Reserva actualizarReserva(Long id, Reserva reservaActualizada){
        Reserva reservaExistente = buscarReservaPorId(id); 

        reservaExistente.setMesa(reservaActualizada.getMesa());
        reservaExistente.setFecha(reservaActualizada.getFecha());
        reservaExistente.setHora(reservaActualizada.getHora());
        reservaExistente.setCantidadPersonas(reservaActualizada.getCantidadPersonas());

        return reservaRepository.save(reservaExistente);
    }
}
