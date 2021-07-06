package ejercicios;

import java.util.Scanner;

public class Multiplos {
    private int cantMultiplos;
    private int numero;

    public void calcular() {
        System.out.println("### Ejercicio 2");
        pedirDatos();
        printMultiplos(this.numero, this.cantMultiplos);
    }

    private void pedirDatos() {
        Scanner in = new Scanner(System.in);

        System.out.print("Ingresa el numero al cual calcular sus multiples: ");
        this.numero = in.nextInt();

        System.out.print("Ingresa la cantidad de multiplos a calcular: ");
        this.cantMultiplos = in.nextInt();
    }

    private void printMultiplos(int numero, int cantMultiplos) {
        String salida = "";
        for (int i = 1; i <= cantMultiplos; i++) {
            salida += (numero * i) + ",";
        }
        System.out.println(salida);
    }
}
