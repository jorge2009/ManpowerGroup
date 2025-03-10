/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestion.Banco.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Jorge
 */
@Data
@Entity
@Table(name="cliente")
public class Cliente {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long ClienteId;
   private String clave;
   private Long estado;

    public Long getClienteId() {
        return ClienteId;
    }

    public void setClienteId(Long ClienteId) {
        this.ClienteId = ClienteId;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }
 
   
}
