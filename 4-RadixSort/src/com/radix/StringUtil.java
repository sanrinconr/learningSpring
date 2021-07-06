package com.radix;

/*
Utils to improve the management of the integers and strings
 */
public class StringUtil {

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int[] arr) {
        String[] out = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            out[i] = String.valueOf(arr[i]);
        }
        return out;

    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String[] arr) {
        int[] out = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            out[i] = Integer.parseInt(arr[i]);
        }
        return out;
    }


    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String[] arr) {
        int max = 0;
        for (String s : arr) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void appendZerosToWord(String[] arr, char c) {
        int max = maxLength(arr);
        for (int i = 0; i < arr.length; i++) {
            int necessary = max - arr[i].length();
            StringBuilder normalized = new StringBuilder(arr[i]);
            for (int j = 0; j < necessary; j++) {
                normalized.insert(0, c);
            }
            arr[i] = normalized.toString();
        }
    }
}
