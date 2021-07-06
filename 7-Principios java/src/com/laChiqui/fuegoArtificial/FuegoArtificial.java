package com.laChiqui.fuegoArtificial;

public class FuegoArtificial {
    private String nombre;
    private String color;
    private String figura;

    public FuegoArtificial(String nombre, String color, String figura) {
        this.nombre = nombre;
        this.color = color;
        this.figura = figura;
    }


    public void detonar() {
        System.out.println("Detonado "+nombre+" , bello color "+color);
    }
}
