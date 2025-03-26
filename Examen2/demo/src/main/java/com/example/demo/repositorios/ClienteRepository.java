package com.example.demo.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente,String>{
    
}
