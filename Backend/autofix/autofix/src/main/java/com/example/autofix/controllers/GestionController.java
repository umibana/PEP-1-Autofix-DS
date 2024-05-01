package com.example.autofix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.autofix.entities.VehiculoEntity;
import com.example.autofix.services.GestionService;

@RestController
@RequestMapping("/api")
public class GestionController {

    @Autowired
    GestionService  gestionService;
    
    @GetMapping("vehiculos")
    List<VehiculoEntity> getVehiculos(){
        return gestionService.getVehiculos();
    }
}
