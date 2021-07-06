package com.tarde.sort;

import java.util.Comparator;

public class BubbleSort<T extends Comparable<T>> extends ISorter<T> {

    @Override
    public void sort(T[] arr, Comparator<T> c) {
        c.compare(arr[0],arr[1]);
    }



    @Override
    public String toString() {
        return "BubbleSort{}";
    }
}
