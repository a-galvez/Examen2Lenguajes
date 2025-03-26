package com.example.demo.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Cliente;
import com.example.demo.repositorios.ClienteRepository;
import com.example.demo.repositorios.CuotaRepository;
import com.example.demo.repositorios.PrestamoRepository;
import com.example.demo.servicios.ClienteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;

    private PrestamoRepository prestamoRepository;

    private CuotaRepository cuotaRepository;

    @Autowired
    private ClienteService clienteService;

    public ClienteController(ClienteRepository clienteRepository, PrestamoRepository prestamoRepository) {
        this.clienteRepository = clienteRepository;
        this.prestamoRepository = prestamoRepository;
    }

    @PostMapping("/crear")
    public Cliente crearCliente(@RequestBody Cliente entity){
        return clienteService.crearCliente(entity);
    }
    
    @GetMapping("/obtenerTodos")
    public List<Cliente> obtenerClientes() {
        return clienteService.obtenerClientes();
    }
    
    
    
}
