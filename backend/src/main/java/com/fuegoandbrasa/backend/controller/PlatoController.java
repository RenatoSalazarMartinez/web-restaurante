package com.fuegoandbrasa.backend.controller;

import com.fuegoandbrasa.backend.model.Plato;
import com.fuegoandbrasa.backend.service.PlatoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;






@RestController //Este controlador recibirá peticiones HTTP y devuelve las rptas en formato JSON
@RequestMapping("/api/platos") // funciona como un mapa de rutas
public class PlatoController {
    private final PlatoService platoService;

    public PlatoController(PlatoService platoService) {
        this.platoService = platoService;
    }

    @GetMapping // El controlador recibirá la petición, le pedirá la lista al servicio y Spring Boot la enviará automáticamente al navegador en formato JSON.
    public List<Plato> listarPlatos() {
        return platoService.listarPlatos();
    }
    
    @PostMapping //Lo usamos cuando queremos enviar o crear datos nuevos
    public Plato crearPlato(@RequestBody Plato plato) {  // @RequestBody le dice a Java que tome ese JSON que viene de internet y lo transforme en un objeto
        return platoService.guardarPlato(plato);
    }

    @GetMapping("/{id}")
    public Plato obtenerPlatoPorId(@PathVariable Long id) {
        return platoService.obtenerPlatoPorId(id);
    }

    @PutMapping("/{id}")
    public Plato actualizarPlato(@PathVariable Long id, @RequestBody Plato platoActualizado){
        return platoService.actualizarPlato(id, platoActualizado);
    }
    
    @DeleteMapping("/{id}")
    public void eliminarPlato(@PathVariable Long id){
        platoService.eliminarPlato(id);
    }
    
    
}
