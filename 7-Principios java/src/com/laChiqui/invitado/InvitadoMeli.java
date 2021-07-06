package com.laChiqui.invitado;

public class InvitadoMeli extends IInvitado{

    public InvitadoMeli(String nombre, String edad) {
        super(nombre, edad);
    }

    @Override
    public void degustar() {
        System.out.println("Que rico esta el pastel! Viva la chiqui!");
    }
}
