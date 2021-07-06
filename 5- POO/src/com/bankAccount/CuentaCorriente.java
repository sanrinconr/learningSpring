package com.bankAccount;

public class CuentaCorriente {
    private String nombre;
    private String numero;
    private double saldo;


    public CuentaCorriente(CuentaCorriente cuenta){
        this.nombre = cuenta.nombre;
        this.numero = cuenta.numero;
        this.saldo = cuenta.saldo;
    }
    public CuentaCorriente(String nombre, String numero){
        this.nombre = nombre;
        this.numero = numero;
    }
    public void ingreso(double value){
        this.saldo += value;
    }

    public void egreso(double value){
        this.saldo -= value;
    }

    public void reingreso(double value){
        egreso(value);
    }

    public void transferencia(double value, CuentaCorriente cuentaDestino) throws Exception {
        if(this.saldo - value < 0){
            throw new Exception("No hay saldo para la transferencia :)");
        }
        this.saldo -= value;
        cuentaDestino.ingreso(value);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
