package com.manana;

public class Main {
    public static void main(String[] args) {
        Precedable[] personas = {
                new Persona("Carlos","393943"),
                new Celular("Juan","1203293"),
                new Persona("Pedro","5543443"),
                new Persona("Camila", "264543")
        };
        Precedable a = new Persona("a","a");
        SortUtil.ordenar(personas);
        SortUtil.printArray(personas);

        System.out.println("...");

        Celular[] celulares = {
                new Celular("Motorola","393943"),
                new Celular("Sony","1203293"),
                new Celular("Huawei","5543443"),
                new Celular("Asus", "264543")
        };
        SortUtil.ordenar(celulares);
        SortUtil.printArray(celulares);
    }
}
