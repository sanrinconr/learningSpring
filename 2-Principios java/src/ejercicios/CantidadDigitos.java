package ejercicios;

import java.util.Scanner;

public class CantidadDigitos {
    private int cantidadNumeros;
    private int minimaCantDigitos;
    private int digitoABuscar;

    public void calcular() {
        System.out.println("### Ejercicio 5");
        pedirDatos();
        printDigitos();
    }

    private void pedirDatos() {
        Scanner in = new Scanner(System.in);

        System.out.print("Cantidad de numeros a mostrar: ");
        this.cantidadNumeros = in.nextInt();

        System.out.print("Digito a buscar: ");
        this.digitoABuscar = in.nextInt();

        System.out.print("Cuantas veces debe estar ese digito como minimo: ");
        this.minimaCantDigitos = in.nextInt();
    }

    private void printDigitos() {
        int cantidadGuardados = 0;
        int numeroActual = 0;
        String salida = "";
        while (cantidadGuardados < this.cantidadNumeros) {
            if (numeroEsValido(numeroActual)) {
                cantidadGuardados++;
                salida += numeroActual + ",";
            }
            numeroActual++;
        }
        System.out.println(salida);
    }

    private boolean numeroEsValido(int numero) {
        int digitosEncontrados = 0;
        while (numero > 0) {
            if (numero % 10 == this.digitoABuscar) digitosEncontrados++;
            numero = numero / 10;

            if (digitosEncontrados >= minimaCantDigitos) {
                return true;
            }
        }
        return false;
    }
}
