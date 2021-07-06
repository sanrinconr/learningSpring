package ejercicios;

import java.util.Scanner;

public class ObtenerPrimos {
    private int cantidad;

    public void calcular() {
        System.out.println("### Ejercicio 4");
        pedirDatos();
        printPrimos(cantidad);
    }

    private void pedirDatos() {
        Scanner in = new Scanner(System.in);

        System.out.print("Ingresa la cantidad de primos que quieres :) : ");
        this.cantidad = in.nextInt();

    }

    private void printPrimos(int numero) {
        int encontrados = 0;
        int busquedaActual = 3;
        String salida = "";
        while (encontrados < numero) {
            if (this.esPrimo(busquedaActual)) {
                encontrados++;
                salida += busquedaActual + ",";
            }
            busquedaActual++;
        }
        System.out.println(salida);
    }

    public boolean esPrimo(int numero) {
        for (int i = numero; i > 0; i--) {
            if (i != numero && i != 1 && numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}
