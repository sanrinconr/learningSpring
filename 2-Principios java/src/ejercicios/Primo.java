package ejercicios;

import java.util.Scanner;

public class Primo {
    private int numero;

    public void calcular() {
        System.out.println("### Ejercicio 3");
        pedirDatos();
        printPrimo(numero);
    }

    private void pedirDatos() {
        Scanner in = new Scanner(System.in);

        System.out.print("Ingresa el numero para saber si es primo :) : ");
        this.numero = in.nextInt();

    }

    private void printPrimo(int numero) {
        ObtenerPrimos obtenerPrimos = new ObtenerPrimos();
        if (obtenerPrimos.esPrimo(numero)) System.out.println("Es primo!");
        else System.out.println("No es primo!");
    }
}
