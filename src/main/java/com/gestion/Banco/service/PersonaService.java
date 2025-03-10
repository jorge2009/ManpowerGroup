/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestion.Banco.service;

import com.gestion.Banco.entity.Cliente;
import com.gestion.Banco.entity.Persona;
import com.gestion.Banco.repository.ClienteRepository;
import com.gestion.Banco.repository.PersonaRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jorge
 */
@Service
public class PersonaService {
     @Autowired
    PersonaRepository personaRepository;
    public ArrayList<Persona> GetPersona(){
    return (ArrayList<Persona>) personaRepository.findAll();
    }
    
    public Optional<Persona> GetPersonaId(Long id){
    return personaRepository.findById(id);
    }
    
    public void SaveOrUpdate(Persona persona){
    personaRepository.save(persona);
    }
    
    public void DeleteId(Long id){
    personaRepository.deleteById(id);
    }
}
