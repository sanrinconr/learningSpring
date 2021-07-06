package com.dakar.vehiculo.socorrista;

import com.dakar.vehiculo.carreras.MotoCarreras;

public class MotoSocorrista extends Socorrista<MotoCarreras>{

    @Override
    public void socorrer(MotoCarreras v) {
        System.out.println("Socorriendo la moto "+ v.getPatente());
    }
}
