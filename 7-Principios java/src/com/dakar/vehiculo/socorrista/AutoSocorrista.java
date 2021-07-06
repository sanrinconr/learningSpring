package com.dakar.vehiculo.socorrista;

import com.dakar.vehiculo.carreras.AutoCarreras;

public class AutoSocorrista extends Socorrista<AutoCarreras> {

    @Override
    public void socorrer(AutoCarreras v) {
        System.out.println("Socorriendo auto con patente "+v.getPatente());
    }
}
