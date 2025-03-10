/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestion.Banco.controller;

import com.gestion.Banco.entity.Cliente;
import com.gestion.Banco.service.ClienteService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jorge
 */
@RestController
@RequestMapping(path="/clientes")
public class ClienteController {
    @Autowired
    ClienteService clienteService;
    @GetMapping
    public List<Cliente> getAll(){
    return clienteService.GetCliente();
    }
    
    @GetMapping("/{id}")
    public Optional<Cliente> getById(@PathVariable("id") Long id){
    return clienteService.GetClienteId(id);
    }
    
    @PostMapping
    public void Save(@RequestBody Cliente cliente){
    clienteService.SaveOrUpdate(cliente);
    }
    
     @DeleteMapping("/{id}")
    public void Delete(@PathVariable("id") Long id){
    clienteService.DeleteId(id);
    }
    
}
