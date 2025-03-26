package com.example.demo.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Cuota;

@Repository
public interface CuotaRepository extends CrudRepository<Cuota,Integer>{
    
}
