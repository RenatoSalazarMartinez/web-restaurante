package com.fuegoandbrasa.backend.controller;

import com.fuegoandbrasa.backend.model.Reserva;
import com.fuegoandbrasa.backend.service.*;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservas")
@RequiredArgsConstructor
public class ReservaController {
    private final ReservaSerivce reservaSerivce;

    @GetMapping
    public List<Reserva> listaReservas(){
        return reservaSerivce.listarReservas();
    }

    @PostMapping
    public Reserva guardarReserva(@RequestBody Reserva reserva){
        return reservaSerivce.guardarReserva(reserva);
    }

    @GetMapping("/{id}")
    public Reserva buscarReservaPorId(@PathVariable Long id){
        return reservaSerivce.buscarReservaPorId(id);
    }

    @PutMapping("/{id}")
    public Reserva actualizarReserva(@PathVariable Long id, @RequestBody Reserva reservaActualizada){
        return reservaSerivce.actualizarReserva(id, reservaActualizada);
    }
}
