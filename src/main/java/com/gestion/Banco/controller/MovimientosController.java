/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestion.Banco.controller;


import am.ik.json.JsonObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestion.Banco.entity.Cliente;
import com.gestion.Banco.entity.Cuenta;
import com.gestion.Banco.entity.Movimientos;
import com.gestion.Banco.entity.Reporte;
import com.gestion.Banco.service.ClienteService;
import com.gestion.Banco.service.CuentaService;
import com.gestion.Banco.service.MovimientoService;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import static java.lang.System.in;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import static org.springframework.http.converter.json.Jackson2ObjectMapperBuilder.json;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jorge
 */
@RestController
@RequestMapping(path="/movimientos")
public class MovimientosController {
    @Autowired
    MovimientoService movimientosService;
    @Autowired
    CuentaService cuentasService;
    
    @GetMapping
    public ArrayList<Movimientos> getAll(){
    return movimientosService.GetMovimientos();
    }
    /*
    @GetMapping("/{id}")
    public Optional<Movimientos> getById(@PathVariable("id") Long id){
    return movimientosService.GetMovimientosId(id);
    }
    */
    @PostMapping
    public String Save(@RequestBody Movimientos movimientos){
        Date fecha=new Date();
        movimientos.setFecha(fecha);
        
        boolean resultado=false;
        boolean realizado=true;
        String mensaje="";
        String tipoMovimiento;
      //  System.err.println("El saldo recibido es "+movimientos.getSaldo()); 
      Long idCuenta;
      idCuenta=movimientos.getCuentaId();
      tipoMovimiento=movimientos.getTipoMovimiento();
      Double saldoInicial;
      Double dep=0.0,ret=0.0;
      Cuenta cuenta=new Cuenta();
      saldoInicial=cuentasService.GetCuentaId(idCuenta).get().getSaldoInicial();
      if(movimientos.getSaldo()==0 || saldoInicial==0){
      mensaje="No existe saldo disponible y el saldo inical es cero";
      realizado=false;
      }else{
          switch (tipoMovimiento) {
              case "deposito":
                  dep=movimientos.getSaldo()+movimientos.getValor();
                  movimientos.setSaldo(dep);
                  mensaje=mensaje+" Deposito corecto";
                  break;
              case "retiro":
                  ret=movimientos.getSaldo()-movimientos.getValor();
                  if(ret<=0){
                  mensaje=mensaje+" No se puede realizar el retiro";
                  realizado=false;
                  break;
                  }else{
                  movimientos.setSaldo(ret);
                  mensaje=mensaje+" Retiro correcto";
                  }
                  
                  break;    
              default:
                  mensaje=mensaje+" Tipo de movimiento no existe";
                  realizado=false;
          }
      }
      
        if(realizado){
      // movimientos.setSaldo(saldo);
      resultado=movimientosService.SaveOrUpdate(movimientos);
        
        }
    if(resultado){
    mensaje=mensaje+" Guardado correctamente";
    }else
    {
    mensaje=mensaje+" Problemas al insertar movimiento";
    }
    return mensaje;
    }
    
     @DeleteMapping("/{id}")
    public void Delete(@PathVariable("id") Long id){
    movimientosService.DeleteId(id);
    }
    
    
     @GetMapping("/fechas")
    public ArrayList<Reporte> getMovimientosPorFecha(@RequestParam("fecha1")@DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha1,
            @RequestParam("fecha2")@DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha2 ){
        SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
        String stringDate="";
        String stringDate2="";
        stringDate=DateFor.format(fecha1);
        stringDate2=DateFor.format(fecha2);
        System.err.println("Fechas "+stringDate+' '+stringDate2);
        ArrayList<Movimientos> movi=new ArrayList<>();
    return movimientosService.ReporteMovimientosFechaCliente(fecha1,fecha2);
    
    
    }
}
