package com.example.autofix.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reparacion")
@Getter
@Setter
public class ReparacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "fecha_ingreso")
    private LocalDate fecha_ingreso;

    @Column(name = "hora_ingreso")
    private LocalTime hora_ingreso;

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

    @Column(name = "monto_reparacion")
    private Integer monto_reparacion;
    
    @Column(name = "fecha_salida")
    private LocalDate fecha_salida;

    @Column(name = "hora_salida")
    private LocalTime hora_salida;

    @Column(name = "fecha_cliente_busco_auto")
    private LocalDate fecha_cliente_busco_auto;
    
    @Column(name = "hora_cliente_busco_auto")
    private LocalTime hora_cliente_busco_auto;
    
    @Column(name = "id_auto")
    private Integer id_auto;

}
