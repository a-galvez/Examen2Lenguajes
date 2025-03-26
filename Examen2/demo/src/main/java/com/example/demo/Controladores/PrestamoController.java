package com.example.demo.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Prestamo;
import com.example.demo.repositorios.ClienteRepository;
import com.example.demo.repositorios.PrestamoRepository;
import com.example.demo.servicios.ClienteService;
import com.example.demo.servicios.PrestamoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

    private ClienteRepository clienteRepository;

    private PrestamoRepository prestamoRepository;

    @Autowired
    private PrestamoService prestamoService;

    public PrestamoController(ClienteRepository clienteRepository, PrestamoRepository prestamoRepository) {
        this.clienteRepository = clienteRepository;
        this.prestamoRepository = prestamoRepository;
    }

    @PostMapping("/crear/{dni}")
    public Prestamo crearPrestamo(@RequestBody Prestamo entity, @RequestParam(name = "dni") String dni) {
        //TODO: process POST request
        
        return prestamoService.crearPrestamo(dni, entity);
    }

    @GetMapping("/obtenerPorID/{idPrestamo}")
    public Prestamo obtenPrestamo(@RequestParam int id) {
        return prestamoService.obtenerPorCodigo(id);
    }
    
    
    
}
