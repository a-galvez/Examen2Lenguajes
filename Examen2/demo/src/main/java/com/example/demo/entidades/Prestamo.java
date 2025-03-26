package com.example.demo.entidades;

import java.time.LocalDate;
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
@Table(name = "prestamos")
@Getter
@Setter
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoPrestamo")
    private int codigoPrestamo;

    @Column(name = "fechaApertura")
    private LocalDate fechaApertura;

    private double monto;

    private double cuota;

    private int plazo;

    private int interes;

    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "dni")
    private Cliente cliente;

    @OneToMany(mappedBy = "prestamos", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cuota> cuotas;

    public Prestamo() {

    }

    public Prestamo(int codigoPrestamo, LocalDate fechaApertura, double monto, double cuota, int plazo, Cliente cliente,
            List<Cuota> cuotas) {
        this.codigoPrestamo = codigoPrestamo;
        this.fechaApertura = fechaApertura;
        this.monto = monto;
        this.cuota = cuota;
        this.plazo = plazo;
        this.cliente = cliente;
        this.cuotas = cuotas;
    }

    
    
}
