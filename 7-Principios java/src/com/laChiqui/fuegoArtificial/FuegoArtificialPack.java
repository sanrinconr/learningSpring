package com.laChiqui.fuegoArtificial;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FuegoArtificialPack {
    private ArrayList<FuegoArtificialPack> packs;
    private ArrayList<FuegoArtificial> fuegos;

    public FuegoArtificialPack(ArrayList<FuegoArtificialPack> packs) {
        this.packs = new ArrayList<>();
        this.fuegos = new ArrayList<>();
    }

    public FuegoArtificialPack() {
        this.packs = new ArrayList<>();
        this.fuegos = new ArrayList<>();
    }

    public void agregarFuegoArtificialAlPack(FuegoArtificial f){
        this.fuegos.add(f);
    }

    public void agregarPack(FuegoArtificialPack p){
        this.packs.add(p);
    }

    public ArrayList<FuegoArtificialPack> getPacks() {
        return packs;
    }

    public ArrayList<FuegoArtificial> getFuegos() {
        return fuegos;
    }
}
