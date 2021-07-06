package com.manana;

public class SortUtil {
    public static void ordenar(Precedable[] arr){
        for(int i = 0 ; i<arr.length ; i++){
            for (int j = 1 ; j < arr.length - i ; j++) {
                if(!arr[j-1].precedeA(arr[j])){
                    Precedable temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }

        }
    }
    public static void printArray(Precedable[] arr){
        for(int i = 0 ; i<arr.length ; i++){
            System.out.println(arr[i].toString());
        }
    }
}
