/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestion.Banco.service;

import com.gestion.Banco.entity.Cliente;
import com.gestion.Banco.entity.Cuenta;
import com.gestion.Banco.entity.Movimientos;
import com.gestion.Banco.entity.Persona;
import com.gestion.Banco.entity.Reporte;
import com.gestion.Banco.repository.ClienteRepository;
import com.gestion.Banco.repository.CuentaRepository;
import com.gestion.Banco.repository.MovimientosRepository;
import com.gestion.Banco.repository.PersonaRepository;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jorge
 */
@Service
public class MovimientoService {
      @Autowired
      MovimientosRepository movimientosRepository;
      @Autowired
      CuentaRepository cuentaRepository;
      @Autowired
      ClienteRepository clienteRepository;
      @Autowired
      PersonaRepository personaRepository;
    public ArrayList<Movimientos> GetMovimientos(){
    return (ArrayList<Movimientos>) movimientosRepository.findAll();
    }
    
    public Optional<Movimientos> GetMovimientosId(Long id){
    return movimientosRepository.findById(id);
    }
    
    public boolean SaveOrUpdate(Movimientos movimientos){
        boolean resultado;
        try {
        movimientosRepository.save(movimientos);
       resultado=true;
        } catch (Exception e) {
        resultado=false;
        }
    
    return resultado;
    }
    
    public void DeleteId(Long id){
    movimientosRepository.deleteById(id);
    }

    
    public ArrayList<Reporte> ReporteMovimientosFechaCliente(Date fecha1,Date fecha2){
        ArrayList<Movimientos> movi=new ArrayList<>();
        ArrayList<Reporte> repo=new ArrayList<>();
        List<Cuenta> cue=new ArrayList<>();
        List<Cliente> cli=new ArrayList<>();
        List<Persona> per=new ArrayList<>();
        Date fecha3=new Date();
        Date fecha4=new Date();
        Date fecha5=new Date();
        movi=movimientosRepository.findAllMovimientos();
       
        movi.size();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
       Reporte reporte=new Reporte();
        for(int i=0;i<movi.size();i++){
            reporte=new Reporte();
           String fechaMovimiento=sdf.format(movi.get(i).getFecha());
           
           if(movi.get(i).getFecha().after(fecha1) && movi.get(i).getFecha().before(fecha2)){
            System.err.println("Movimientos "+fechaMovimiento);
             cue=cuentaRepository.findAll();
             for(int j=0;j<cue.size();j++){
             if(cue.get(j).getCuentaId()==movi.get(i).getCuentaId()){
             reporte.setCuenta(cue.get(j).getNumeroCuenta());
             reporte.setTipoCuenta(cue.get(j).getTipoCuenta());
             reporte.setSaldoIncial(cue.get(j).getSaldoInicial());
             reporte.setEstado(cue.get(j).getEstado());
             reporte.setSaldo(movi.get(i).getSaldo());
             reporte.setValor(movi.get(i).getValor());
             per=personaRepository.findAll();
             for(int k=0;k<per.size();k++){
                 if(per.get(k).getClienteId()==cue.get(j).getClienteId()){
                  reporte.setNombre(per.get(k).getNombre());
                 }
            
             }
             
             }
             }  
            reporte.setFecha(movi.get(i).getFecha());
            repo.add(reporte);   
           
           } else {

           }
          
        }
        System.err.println("Total de datos encontrados "+repo.size());
        for(Reporte rep: repo){
            System.err.println("Datos "+rep.getCuenta());
            System.err.println("Datos "+rep.getNombre());
            System.err.println("Datos "+rep.getTipoCuenta());
            System.err.println("Datos "+rep.getFecha());
            System.err.println("Datos "+rep.getSaldo());
            System.err.println("Datos "+rep.getSaldoIncial());
            System.err.println("Datos "+rep.getValor());
        }
    /*
        SELECT mov.fecha,per.nombre,cue.numero_cuenta,cue.tipo_cuenta,cue.saldo_inicial,
        cue.estado,mov.valor,mov.saldo FROM `movimientos` mov,cuenta cue,cliente cli,
        persona per WHERE mov.cuenta_id=cue.cuenta_id and cli.cliente_id=cue.cliente_id 
        and per.cliente_id=cli.cliente_id;
        
        */
    return repo;
    }
    
}
