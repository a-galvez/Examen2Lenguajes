package com.example.demo.servicios;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Cuota;
import com.example.demo.entidades.Prestamo;
import com.example.demo.repositorios.ClienteRepository;
import com.example.demo.repositorios.CuotaRepository;
import com.example.demo.repositorios.PrestamoRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private CuotaRepository cuotaRepository;

    public Cliente crearCliente(Cliente cliente){
        List<Cliente> clientes = (List<Cliente>) this.clienteRepository.findAll();

        for (Cliente clienteComp : clientes) {
            if(clienteComp.getDni().equals(cliente.getDni())){
                return null;
            }
        }

        Cliente nvoCliente = new Cliente();
        nvoCliente.setDni(cliente.getDni());
        nvoCliente.setNombre(cliente.getNombre());
        nvoCliente.setApellido(cliente.getApellido());
        nvoCliente.setTelefono(cliente.getTelefono());

        if(cliente.getPrestamos() != null){
            List<Prestamo> prestamo = new LinkedList<Prestamo>();
            Prestamo pres = new Prestamo();

            nvoCliente.setPrestamos(prestamo);
            pres.setFechaApertura(cliente.getPrestamo().getFechaApertura());
            pres.setMonto(cliente.getPrestamo().getMonto());
            pres.setInteres(cliente.getPrestamo().getInteres());
            pres.setPlazo(cliente.getPrestamo().getPlazo());
            
           

            double p = pres.getMonto();
            double tasa = pres.getInteres() / 12;
            double n = pres.getPlazo() * 12;
            double paren = (1 + tasa) * Math.exp(n);
            double num = p * tasa;
            double deno = 1 - paren;

            double cuotaP = num / deno;

            pres.setCuota(cuotaP);
            prestamo.add(pres);

            List<Cuota> cuotas = new LinkedList<Cuota>();
            Cuota cuot = new Cuota();
            
            this.prestamoRepository.save(pres);
        }

        this.clienteRepository.save(nvoCliente);


        return nvoCliente;
    }

    public List<Cliente> obtenerClientes(){
        List<Cliente> clientes = (List<Cliente>) this.clienteRepository.findAll();


        if(clientes != null){
            return clientes;
        }

        return null;

    }

    
}
