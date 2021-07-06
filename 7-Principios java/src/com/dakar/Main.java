package com.dakar;

import com.dakar.carrera.Carrera;
import com.dakar.vehiculo.carreras.AutoCarreras;
import com.dakar.vehiculo.carreras.MotoCarreras;
import com.dakar.vehiculo.carreras.VehiculoCarreras;

public class Main {
    public static void main(String[] args) throws Exception {
        VehiculoCarreras a = new MotoCarreras(1,1,1,"AAAA");
        VehiculoCarreras b = new AutoCarreras(1,1,1,"BBBB");

        Carrera carrera = new Carrera(10,10000,"Vueltica",3);

        carrera.darDeAltaVehiculo(a);
        carrera.darDeAltaVehiculo(b);

        carrera.socorrer(b);

    }
}
