package com.laChiqui.invitado;

public abstract class IInvitado {
    private String nombre;
    private String edad;
    public IInvitado(String nombre, String edad){
        this.nombre = nombre;
        this.edad = edad;
    }
    public abstract void degustar();
}
