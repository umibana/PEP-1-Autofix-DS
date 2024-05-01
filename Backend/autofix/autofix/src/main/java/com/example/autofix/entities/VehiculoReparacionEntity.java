package com.example.autofix.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "vehiculo_reparacion")
@Getter
@Setter
public class VehiculoReparacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo_reparacion")
    private String tipo_reparacion; 
    /*  Reparaciones del Sistema de Frenos
        Servicio del Sistema de Refrigeración
        Reparaciones del Motor
        Reparaciones de la Transmisión
        Reparación del Sistema Eléctrico
        Reparaciones del Sistema de Escape
        Reparación de Neumáticos y Ruedas
        Reparaciones de la Suspensión y la Dirección
        Reparación del Sistema de Aire Acondicionado y Calefacción
        Reparaciones del Sistema de Combustible
        Reparación y Reemplazo del Parabrisas y Cristales */
    
    @Column (name = "costo")
    private Integer costo;

    @Column (name = "idauto")
    private Long idauto;
}
