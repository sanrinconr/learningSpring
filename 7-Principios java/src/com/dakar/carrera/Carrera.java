package com.dakar.carrera;

import com.dakar.vehiculo.carreras.AutoCarreras;
import com.dakar.vehiculo.carreras.MotoCarreras;
import com.dakar.vehiculo.carreras.VehiculoCarreras;
import com.dakar.vehiculo.socorrista.AutoSocorrista;
import com.dakar.vehiculo.socorrista.MotoSocorrista;
import com.dakar.vehiculo.socorrista.Socorrista;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private int distancia;
    private int premioDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private List<VehiculoCarreras> participantes;
    private Socorrista[] socorristas;

    public Carrera(int distancia, int premioDolares, String nombre, int cantidadVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioDolares = premioDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.participantes = new ArrayList<>();
        this.socorristas = new Socorrista[]{new AutoSocorrista(), new MotoSocorrista()};
    }

    public void socorrer(VehiculoCarreras v) throws Exception {
        if(!participantes.contains(v)) throw new Exception("No se socorre a alguien que no esta en la carrera");
        String nameClass = v.getClass().getName();
        switch (nameClass) {
            case "com.dakar.vehiculo.carreras.MotoCarreras":
                socorristas[1].socorrer(v);
                break;
            case "com.dakar.vehiculo.carreras.AutoCarreras":
                socorristas[0].socorrer(v);
        }
    }

    public void darDeAltaVehiculo(VehiculoCarreras vehiculoCarreras) throws Exception {
        if (participantes.size() < cantidadVehiculosPermitidos) {
            participantes.add(vehiculoCarreras);
        } else {
            throw new Exception("La carrera esta llena!");
        }
    }

    /*
    Eliminacion de un vehiculo
     */
    public void eliminarVehiculo(VehiculoCarreras vehiculoCarreras) {
        this.participantes.remove(vehiculoCarreras);
    }

    public void eliminarVehiculo(String patente) {
        VehiculoCarreras vEliminar = buscarVehiculo(patente);
        if (vEliminar == null) System.out.println("No existe un vehiculo con patente " + patente + "en la carrera");
        else eliminarVehiculo(vEliminar);
    }

    private VehiculoCarreras buscarVehiculo(String patente) {
        for (VehiculoCarreras v : participantes) {
            if (v.getPatente().equalsIgnoreCase(patente)) {
                return v;
            }
        }
        return null;
    }

    public VehiculoCarreras getGanador() throws Exception {
        if (participantes.size() == 0) throw new Exception("No hay participantes en la carrera");
        VehiculoCarreras ganadorTemp = null;
        double mejorPuntaje = 0;
        for (VehiculoCarreras v : participantes) {
            double puntateActual = getPuntajeParticipante(v);
            if (puntateActual > mejorPuntaje) {
                mejorPuntaje = puntateActual;
                ganadorTemp = v;
            }
        }
        return ganadorTemp;
    }

    private double getPuntajeParticipante(VehiculoCarreras v) {
        double num = (v.getVelocidad() * (0.5 * v.getAcceleracion()));
        double den = (v.getAnguloGiro() * (v.getPeso() - v.getRuedas() * 100));
        return num / den;
    }

}
