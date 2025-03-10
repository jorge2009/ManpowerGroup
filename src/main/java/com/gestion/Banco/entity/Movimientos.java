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
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Jorge
 */
@Data
@Entity
@Table(name="movimientos")
public class Movimientos {
       @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long MovimientoId;
   private String tipoMovimiento;
   private Double valor;
   private Double saldo;
   private Long CuentaId;
   private Date fecha;

    public Long getMovimientoId() {
        return MovimientoId;
    }

    public void setMovimientoId(Long MovimientoId) {
        this.MovimientoId = MovimientoId;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Long getCuentaId() {
        return CuentaId;
    }

    public void setCuentaId(Long CuentaId) {
        this.CuentaId = CuentaId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
   
   
}
