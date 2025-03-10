/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestion.Banco.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Jorge
 */
@Data
@Entity
@Table(name="persona")
public class Persona {
  @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long PersonaId;
   private String nombre;
   private String genero;
   private String edad;
   private String identificacion;
   private String direccion;
   private String telefono;
   private Long ClienteId; 

    public Long getPersonaId() {
        return PersonaId;
    }

    public void setPersonaId(Long PersonaId) {
        this.PersonaId = PersonaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Long getClienteId() {
        return ClienteId;
    }

    public void setClienteId(Long ClienteId) {
        this.ClienteId = ClienteId;
    }
   
}
