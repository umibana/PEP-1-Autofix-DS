package com.example.autofix.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.autofix.entities.VehiculoEntity;
import com.example.autofix.repositories.VehiculoRepository;

@Service
public class GestionService {

    @Autowired
    VehiculoRepository vehiculoRepository;

    public ArrayList<VehiculoEntity> getVehiculos(){
        return (ArrayList<VehiculoEntity>) vehiculoRepository.findAll();
    }

    public VehiculoEntity saveVehiculo(VehiculoEntity vehiculo){
        return vehiculoRepository.save(vehiculo);
    }

    

}
