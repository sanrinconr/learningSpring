package ejercicios;

import java.util.Scanner;

public class NPares {
    private int n;

    public void calcular() {
        System.out.println("### Ejercicio 1");
        pedirDatos();
        printNPares(n);
    }

    private void pedirDatos() {
        System.out.print("Ingresa la cantidad de pares a imprimir: ");
        Scanner in = new Scanner(System.in);
        this.n = in.nextInt();
    }

    private void printNPares(int n) {
        String salida = "";
        for (int i = 0; i < n * 2; i++) {
            if (i % 2 == 0) {
                salida += i + ",";
            }
        }
        System.out.println(salida);
    }
}
