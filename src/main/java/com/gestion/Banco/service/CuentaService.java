/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestion.Banco.service;

import com.gestion.Banco.entity.Cliente;
import com.gestion.Banco.entity.Cuenta;
import com.gestion.Banco.repository.ClienteRepository;
import com.gestion.Banco.repository.CuentaRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jorge
 */
@Service
public class CuentaService {
      @Autowired
    CuentaRepository cuentaRepository;
    public ArrayList<Cuenta> GetCuenta(){
    return (ArrayList<Cuenta>) cuentaRepository.findAll();
    }
    
    
    public Optional<Cuenta> GetCuentaId(Long id){
    return cuentaRepository.findById(id);
    }
    
    public void SaveOrUpdate(Cuenta cuenta){
    cuentaRepository.save(cuenta);
    }
    
    public void DeleteId(Long id){
    cuentaRepository.deleteById(id);
    }
}
