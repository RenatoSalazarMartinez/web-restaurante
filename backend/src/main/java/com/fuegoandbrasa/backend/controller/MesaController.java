package com.fuegoandbrasa.backend.controller;

import org.springframework.web.bind.annotation.*;
import com.fuegoandbrasa.backend.service.MesaService;
import com.fuegoandbrasa.backend.model.*;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.http.ResponseEntity;



@RestController
@RequestMapping("/api/mesas")
@RequiredArgsConstructor
public class MesaController {
    private final MesaService mesaService;

    @GetMapping
    public ResponseEntity<List<Mesa>> listarMesas(){
        return ResponseEntity.ok(mesaService.listarMesas());
    }
    
    @PostMapping
    public ResponseEntity<Mesa> crearMesa(@RequestBody Mesa mesa){
        return ResponseEntity.ok(mesaService.guardarMesa(mesa));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Mesa>> buscarMesaPorEstado(@PathVariable EstadoMesa estado){
        return ResponseEntity.ok(mesaService.buscarPorEstado(estado));
    }

    @PatchMapping("/{id}/estado") //@PatchMapping se utiliza cuando solo se quiere actualizar algunos campos específicos de un objeto, dejando el resto exactamente como estaba.
    public ResponseEntity<Mesa> actualizarEstadoMesa(@PathVariable Long id, @RequestParam EstadoMesa estado){  //@RequestParam le dice a Spring Boot que busque el valor directamente en la URL como un parámetro de consulta
        return ResponseEntity.ok(mesaService.actualizarEstado(id, estado));
    }
}
