package com.example.demo.entidades;
import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cuotas")
@Getter
@Setter
public class Cuota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoCuota")
    private int codigoCuota;

    private int mes;

    private double interes;

    private double capital;

    private double saldo;

    @ManyToOne
    @JoinColumn(name = "prestamos", referencedColumnName = "codigoPrestamo")
    private Prestamo prestamo;

    public Cuota() {

    }

    public Cuota(int codigoCuota, int mes, double interes, double capital, double saldo, Prestamo prestamo) {
        this.codigoCuota = codigoCuota;
        this.mes = mes;
        this.interes = interes;
        this.capital = capital;
        this.saldo = saldo;
        this.prestamo = prestamo;
    }
    
    
}
