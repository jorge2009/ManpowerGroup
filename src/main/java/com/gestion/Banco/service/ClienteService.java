/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestion.Banco.service;

import com.gestion.Banco.entity.Cliente;
import com.gestion.Banco.repository.ClienteRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jorge
 */
@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;
    public ArrayList<Cliente> GetCliente(){
    return (ArrayList<Cliente>) clienteRepository.findAll();
    }
    
    public Optional<Cliente> GetClienteId(Long id){
    return clienteRepository.findById(id);
    }
    
    public void SaveOrUpdate(Cliente cliente){
    clienteRepository.save(cliente);
    }
    
    public void DeleteId(Long id){
    clienteRepository.deleteById(id);
    }
}
