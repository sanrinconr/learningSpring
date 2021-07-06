package com.tarde.sort;

import java.util.Comparator;
//Extends from comparable for make T only for bounded types, in this case, we need all T implements compareTo
//method to make the comparison with comparable
public abstract class ISorter<T extends Comparable<T>> {
    public abstract void sort(T arr[], Comparator<T> c);
    public void printResult(T[] arr) {
        for(T e:arr){
            System.out.println(e.toString());
        }
    }
}
