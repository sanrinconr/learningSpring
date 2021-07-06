package com.laChiqui.fuegoArtificial;

import java.util.ArrayList;

public class AlmacenFuegosArtificiales {
    private ArrayList<FuegoArtificial> fuegos;
    private ArrayList<FuegoArtificialPack> packs;

    public AlmacenFuegosArtificiales() {
        this.fuegos = new ArrayList<>();
        this.packs = new ArrayList<>();
    }

    public void agregarFuegoArtificial(FuegoArtificial f){
        this.fuegos.add(f);
    }

    public void agregarPackFuedoArticial(FuegoArtificialPack f){
        this.packs.add(f);
    }

    public void detonarTodos(){
        detonarFuegos();
        detonarPacks();
    }
    private void detonarFuegos(){
        for (FuegoArtificial f:fuegos){
            f.detonar();
        }
    }
    private void detonarPacks(){
        for(FuegoArtificialPack p:packs){
            detonarPack(p);
        }
    }
    private void detonarPack(FuegoArtificialPack pack){
        //Detonar los fuegos
        for(FuegoArtificial f: pack.getFuegos()){
            f.detonar();
        }
        //Detonar los demas packs
        for (FuegoArtificialPack p:pack.getPacks()){
            detonarPack(p);
        }
    }
}
