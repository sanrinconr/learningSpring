package com.laChiqui.invitado;

public class InvitadoStandard extends IInvitado{
    public InvitadoStandard(String nombre, String edad) {
        super(nombre, edad);
    }

    @Override
    public void degustar() {
        System.out.println("Que rico esta el pastel!");
    }
}
