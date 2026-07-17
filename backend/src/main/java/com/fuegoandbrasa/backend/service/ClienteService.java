package com.fuegoandbrasa.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fuegoandbrasa.backend.model.Cliente;
import com.fuegoandbrasa.backend.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public Cliente guardarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente buscarClientePorId(Long id){
        return clienteRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se ha encontrado al cliente con el ID: "+id));
    }

    public Cliente actualizarCliente(Long id,Cliente clienteActualizado){
        Cliente clienteExistente = buscarClientePorId(id);
        
        clienteExistente.setNombreCompleto(clienteActualizado.getNombreCompleto());
        clienteExistente.setTelefono(clienteActualizado.getTelefono());
        clienteExistente.setCorreoElectronico(clienteActualizado.getCorreoElectronico());

        return clienteRepository.save(clienteExistente);
    }

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }
}
