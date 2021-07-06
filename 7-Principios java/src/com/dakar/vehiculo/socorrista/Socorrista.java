package com.dakar.vehiculo.socorrista;

import com.dakar.vehiculo.carreras.VehiculoCarreras;

public abstract class Socorrista<T extends VehiculoCarreras> {
    public abstract void socorrer(T v);
}
