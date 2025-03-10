/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gestion.Banco.repository;

import com.gestion.Banco.entity.Movimientos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jorge
 */
@Repository
public interface MovimientosRepository extends JpaRepository<Movimientos, Long>{
         @Query("SELECT m FROM Movimientos m WHERE m.saldo>1")
          ArrayList<Movimientos> findAllMovimientos();
         
}
