package com.oficinaultracar.controllers;


import com.oficinaultracar.entites.Cliente;
import com.oficinaultracar.Repositories.ClienteRepository;
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
        return repository.findAll();
    }

    @PostMapping
    public Cliente insert(@RequestBody Cliente cliente) {
        return repository.save(cliente);
    }

    @GetMapping(value = "/{id}")
    public Cliente findById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PutMapping(value = "/{id}")
    public Optional<Cliente> update(@PathVariable Long id, @RequestBody Cliente cliente) {
        Optional<Cliente> existingClienteOptional = repository.findById(id);

        if (existingClienteOptional.isPresent()) {
            Cliente existingCliente = existingClienteOptional.get();
            existingCliente.setNome(cliente.getNome());
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
