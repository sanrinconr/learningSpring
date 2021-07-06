package com.dakar.vehiculo.carreras;

public class VehiculoCarreras {
    private int velocidad;
    private int acceleracion;
    private int anguloGiro;
    private String patente;
    private int peso;
    private int ruedas;

    public VehiculoCarreras(int velocidad, int acceleracion, int anguloGiro, String patente, int peso, int ruedas) {
        this.velocidad = velocidad;
        this.acceleracion = acceleracion;
        this.anguloGiro = anguloGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getAcceleracion() {
        return acceleracion;
    }

    public int getAnguloGiro() {
        return anguloGiro;
    }

    public String getPatente() {
        return patente;
    }

    public int getPeso() {
        return peso;
    }

    public int getRuedas() {
        return ruedas;
    }
}
