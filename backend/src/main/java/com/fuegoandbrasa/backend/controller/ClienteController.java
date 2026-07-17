package com.fuegoandbrasa.backend.controller;

import com.fuegoandbrasa.backend.model.Cliente;
import com.fuegoandbrasa.backend.service.*;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;

    @PostMapping
    public Cliente guardarCliente(@RequestBody Cliente cliente){
        return clienteService.guardarCliente(cliente);
    }
    
    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @GetMapping("/{id}")
    public Cliente buscarClientePorId(@PathVariable Long id){
        return clienteService.buscarClientePorId(id);
    }

    @PutMapping("/{id}")
    public Cliente actualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteActualizado){
        return clienteService.actualizarCliente(id, clienteActualizado);
    } 
}
