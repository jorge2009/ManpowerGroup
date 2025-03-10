/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestion.Banco.controller;

import com.gestion.Banco.entity.Cliente;
import com.gestion.Banco.entity.Persona;
import com.gestion.Banco.service.ClienteService;
import com.gestion.Banco.service.PersonaService;
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
@RequestMapping(path="/personas")
public class PersonaController {
    @Autowired
    PersonaService personaService;
    @GetMapping
    public List<Persona> getAll(){
    return personaService.GetPersona();
    }
    
    @GetMapping("/{id}")
    public Optional<Persona> getById(@PathVariable("id") Long id){
    return personaService.GetPersonaId(id);
    }
    
    @PostMapping
    public void Save(@RequestBody Persona persona){
    personaService.SaveOrUpdate(persona);
    }
    
     @DeleteMapping("/{id}")
    public void Delete(@PathVariable("id") Long id){
    personaService.DeleteId(id);
    }
}
