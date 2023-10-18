package com.oficinaultracar.controllers;

import com.oficinaultracar.Repositories.ClienteRepository;
import com.oficinaultracar.entites.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public List<Cliente> findAll() {
        List<Cliente> result = repository.findAll();
        return result;
    }

    @PostMapping
    public Cliente insert(@RequestBody Cliente cliente) {
        Cliente result = repository.save(cliente);
        return result;
    }

    @GetMapping(value = "/{id}")
    public Cliente findById(@PathVariable Long id) {
        Cliente result = repository.findById(id).get();
        return result;
    }

    @PutMapping(value = "/{id}")
    public Optional<Cliente> update(@PathVariable Long id, @RequestBody Cliente cliente) {
        Optional<Cliente> existingClienteOptional = repository.findById(id);

        if (existingClienteOptional.isPresent()) {
            Cliente existingCliente = existingClienteOptional.get();
            existingCliente.setCliente(cliente.getCliente());
            existingCliente.setEmail(cliente.getEmail());
            existingCliente.setTelefone(cliente.getTelefone());

            Cliente updatedCliente = repository.save(existingCliente);

            return Optional.of(updatedCliente);
        }
        return existingClienteOptional;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Optional<Cliente> existingClienteOptional = repository.findById(id);

        if (existingClienteOptional.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok("Cliente com ID " + id + " foi excluído com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente com ID " + id + " não encontrado.");
        }
    }

}