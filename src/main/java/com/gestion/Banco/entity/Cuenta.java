/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestion.Banco.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="cuenta")
public class Cuenta {
     @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long CuentaId;
   private Long numeroCuenta;
   private String tipoCuenta;
   private Double saldoInicial;
   private String estado;
   private Long ClienteId;

    public Long getCuentaId() {
        return CuentaId;
    }

    public void setCuentaId(Long CuentaId) {
        this.CuentaId = CuentaId;
    }

    public Long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getClienteId() {
        return ClienteId;
    }

    public void setClienteId(Long ClienteId) {
        this.ClienteId = ClienteId;
    }
   
   
}
