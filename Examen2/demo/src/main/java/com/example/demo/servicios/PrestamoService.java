package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Prestamo;
import com.example.demo.repositorios.ClienteRepository;
import com.example.demo.repositorios.CuotaRepository;
import com.example.demo.repositorios.PrestamoRepository;

@Service
public class PrestamoService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private CuotaRepository cuotaRepository;

    public Prestamo obtenerPorCodigo(int idPrestamo){
        Prestamo pre = this.prestamoRepository.findById(idPrestamo).get();

        if(pre != null){
            return pre;
        }

        return null;

    }

    public Prestamo crearPrestamo(String dni, Prestamo prestamo){
        Cliente cliente = this.clienteRepository.findById(dni).get();

        if(cliente != null && (cliente.getPrestamos().size() < 2)){
            Prestamo nvoPrestamo = new Prestamo();
            nvoPrestamo.setCliente(cliente);
            nvoPrestamo.setFechaApertura(prestamo.getFechaApertura());
            nvoPrestamo.setMonto(prestamo.getMonto());
            nvoPrestamo.setInteres(prestamo.getInteres());
            nvoPrestamo.setPlazo(prestamo.getPlazo());

            this.prestamoRepository.save(nvoPrestamo);

            return nvoPrestamo;

        }

        return null;


    }
    
}
