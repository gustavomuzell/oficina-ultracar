package com.oficinaultracar.Repositories;

import com.oficinaultracar.entites.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}

