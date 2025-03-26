package com.example.demo.entidades;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cliente")
@Getter
@Setter
public class Cliente {

    @Id
    @Column(name = "dni")
    private String dni;

    private String nombre;

    private String apellido;

    private String telefono;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Prestamo> prestamos;

    private Prestamo prestamo;

    public Cliente(){

    }

    public Cliente(String dni, String nombre, String apellido, String telefono, List<Prestamo> prestamos) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.prestamos = prestamos;
    }

    
    
}
