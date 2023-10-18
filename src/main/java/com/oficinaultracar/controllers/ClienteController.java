package com.oficinaultracar.controllers;

import com.oficinaultracar.Repositories.ClienteRepository;
import com.oficinaultracar.entites.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public List<Cliente> findAll(){
  List<Cliente> result =  repository.findAll();
    return result;
    }

}
