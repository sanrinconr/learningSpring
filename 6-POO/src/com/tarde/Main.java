package com.tarde;

import com.tarde.factory.Mifactory;
import com.tarde.sort.ISorter;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ISorter a = Mifactory.getInstance();
        String[] elements = {"b", "a"};
        Integer[] integers = {4, 3, 2, 1};

        //Go to compare objects only if extends from Comparable (because we need compareTo method)

        //Legacy version
        /*a.sort(elements, new Comparator<Comparable>() {
            @Override
            public int compare(Comparable o1, Comparable o2) {
                return o1.compareTo(o2);
            }
        });*/

        //Lambda version
        a.sort(integers, (Comparator<Comparable>) (o1, o2) -> o1.compareTo(o2));
        //Pro version ( by intellij )
//        a.sort(elements, (Comparator<Comparable>) Comparator.naturalOrder());


        a.printResult(integers);

    }

}
