package com.example.autofix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.autofix.entities.HistorialReparacionEntity;
import com.example.autofix.entities.VehiculoEntity;
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



    @GetMapping("/historial_reparacion")
    public ResponseEntity<List<HistorialReparacionEntity>> getHistorialReaparaciones(){
        List<HistorialReparacionEntity> reparaciones = gestionService.getHistoriales();
        return ResponseEntity.ok(reparaciones);
    }

    @PostMapping("/historial_reparacion")
    public ResponseEntity<HistorialReparacionEntity> saveHistorialReparacion(@RequestBody HistorialReparacionEntity reparacion){
        HistorialReparacionEntity reparacionNew = gestionService.saveHistorialReparacion(reparacion);
        return ResponseEntity.ok(reparacionNew);
    }

}
