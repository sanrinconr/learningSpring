package com.laChiqui;

import com.laChiqui.fuegoArtificial.AlmacenFuegosArtificiales;
import com.laChiqui.fuegoArtificial.FuegoArtificial;
import com.laChiqui.fuegoArtificial.FuegoArtificialPack;
import com.laChiqui.invitado.IInvitado;
import com.laChiqui.invitado.InvitadoMeli;
import com.laChiqui.invitado.InvitadoStandard;

public class Main {
    public static void main(String[] args) {

        /*Invitados*/
        IInvitado a = new InvitadoMeli("Ana","19");
        IInvitado b = new InvitadoMeli("Juan","19");
        IInvitado c = new InvitadoStandard("Juanita","19");
        IInvitado d = new InvitadoStandard("Valentina","19");
        IInvitado e = new InvitadoStandard("Paulina","19");


        /*Fuegos artificiales*/
        FuegoArtificial estrellas = new FuegoArtificial("estrellas furia", "rojo","circulo");
        FuegoArtificial circulos = new FuegoArtificial("circulos sencillos", "rojo","circulo");
        FuegoArtificial oso = new FuegoArtificial("Oso explosion", "blanco","cuadrada");
        FuegoArtificial anioNuevo = new FuegoArtificial("anioNuevo", "blanco","rectangulo");
        FuegoArtificial diaDeLaTierra = new FuegoArtificial("diaDeLaTierra", "verde","circulo");

        FuegoArtificialPack blancos = new FuegoArtificialPack();
        blancos.agregarFuegoArtificialAlPack(anioNuevo);
        blancos.agregarFuegoArtificialAlPack(oso);


        FuegoArtificialPack rojos = new FuegoArtificialPack();
        rojos.agregarFuegoArtificialAlPack(estrellas);
        rojos.agregarFuegoArtificialAlPack(circulos);

        FuegoArtificialPack blancosRojos = new FuegoArtificialPack();
        blancosRojos.agregarPack(blancosRojos);


        AlmacenFuegosArtificiales almacenFuegosArtificiales = new AlmacenFuegosArtificiales();
        //almacenFuegosArtificiales.agregarPackFuedoArticial(blancosRojos);
        almacenFuegosArtificiales.agregarPackFuedoArticial(blancos);
        almacenFuegosArtificiales.agregarPackFuedoArticial(rojos);
        almacenFuegosArtificiales.detonarTodos();


    }
}
