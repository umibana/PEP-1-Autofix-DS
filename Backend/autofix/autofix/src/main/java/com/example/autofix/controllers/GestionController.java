package com.example.autofix.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.autofix.entities.BonoEntity;
import com.example.autofix.entities.HistorialReparacionEntity;
import com.example.autofix.entities.ReporteCostoEntity;
import com.example.autofix.entities.VehiculoEntity;
import com.example.autofix.entities.VehiculoReparacionEntity;
import com.example.autofix.services.GestionService;


@RestController
@RequestMapping("/api")
public class GestionController {

    @Autowired
    GestionService  gestionService;
    
    @GetMapping("/vehiculo")
    public ResponseEntity<List<VehiculoEntity>> getVehiculos(){
        List<VehiculoEntity> vehiculos = gestionService.getVehiculos();
        return ResponseEntity.ok(vehiculos);
    }

    @PostMapping("/vehiculo")
    public ResponseEntity<VehiculoEntity> saveVehiculo(@RequestBody VehiculoEntity vehiculo){
        VehiculoEntity vehiculoNew = gestionService.saveVehiculo(vehiculo);
        return ResponseEntity.ok(vehiculoNew);
    }

    @GetMapping("/reparacion")
    public ResponseEntity<List<VehiculoReparacionEntity>> getVehiculoReparaciones(){
        List<VehiculoReparacionEntity> vehiculaReparcion = gestionService.getVehiculosReparaciones();
        return ResponseEntity.ok(vehiculaReparcion);
    }

    @PostMapping("/reparacion")
    public ResponseEntity<List<VehiculoReparacionEntity>> guardarListaReparacionesVehiculo(@RequestBody List<VehiculoReparacionEntity> reparaciones){
        List<VehiculoReparacionEntity> reparacionesGuardadas = gestionService.guardarListaReparacionVehiculo(reparaciones);
        return ResponseEntity.ok(reparacionesGuardadas);
    }

    @GetMapping("/bono")
    public ResponseEntity<List<BonoEntity>> getBonos(){
        List<BonoEntity> bonos = gestionService.getBonos();
        return ResponseEntity.ok(bonos);
    }

    @PostMapping("/bono")
    public ResponseEntity<BonoEntity> saveBono(@RequestBody BonoEntity bono){
        BonoEntity bonoNew = gestionService.saveBono(bono);
        return ResponseEntity.ok(bonoNew);
    }

    @PostMapping("/vehiculo/bono")
    public ResponseEntity<Void> actualizacionBono(@RequestBody VehiculoEntity vehiculo){
        gestionService.actualizarFlagBono(vehiculo.getId());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/historial_reparacion")
    public ResponseEntity<List<HistorialReparacionEntity>> getHistorialReaparaciones(){
        List<HistorialReparacionEntity> reparaciones = gestionService.getHistoriales();
        return ResponseEntity.ok(reparaciones);
    }

    @PostMapping("/historial_reparacion")
    public ResponseEntity<HistorialReparacionEntity> saveHistorialReparacion(@RequestBody HistorialReparacionEntity reparacion){
        HistorialReparacionEntity historialNew = gestionService.saveHistorialReparacion(reparacion);
        return ResponseEntity.ok(historialNew);
    }

    @PostMapping("/historial_reparacion/salida")
    public ResponseEntity<HistorialReparacionEntity> guardarSalidaHistorialReparacion(@RequestBody VehiculoEntity vehiculo, @RequestParam("fechaSalida") LocalDate fechaSalida, @RequestParam("horaSalida") LocalTime horaSalida){
        HistorialReparacionEntity historialSalidaNew = gestionService.guardarHistorialReparacionEntity(vehiculo.getId(), fechaSalida, horaSalida);
        return ResponseEntity.ok(historialSalidaNew);
    }

    @PostMapping("/historial_reparacion/cliente")
    public ResponseEntity<HistorialReparacionEntity> actualizacionHistorialReparacion(@RequestBody VehiculoEntity vehiculo, @RequestParam("fechaCliente") LocalDate fechaCliente, @RequestParam("horaCliente") LocalTime horaCliente){
        HistorialReparacionEntity reparacionUpdated = gestionService.updateHistoriaReparacionEntity(vehiculo.getId(),fechaCliente,horaCliente);
        return ResponseEntity.ok(reparacionUpdated);
    }
    @GetMapping("/reporte_costo")
    public ResponseEntity<List<ReporteCostoEntity>> getReportesCosto(){
        List<ReporteCostoEntity> reportes = gestionService.getReporteCosto();
        return ResponseEntity.ok(reportes);
    }

}
