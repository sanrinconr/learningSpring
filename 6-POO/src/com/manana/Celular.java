package com.manana;

public class Celular implements Precedable<Celular> {
    private String modelo;
    private String imei;

    public Celular(String modelo, String imei) {
        this.modelo = modelo;
        this.imei = imei;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    @Override
    public boolean precedeA(Celular celular) {
        if(celular.imei.compareTo(this.imei) > 0){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Celular{" +
                "modelo='" + modelo + '\'' +
                ", imei='" + imei + '\'' +
                '}';
    }
}
