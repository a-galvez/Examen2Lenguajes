package com.example.demo.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Prestamo;

@Repository
public interface PrestamoRepository extends CrudRepository<Prestamo,Integer>{
    
}
