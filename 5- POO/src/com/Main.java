package com;

import com.fraction.Fraction;
import com.library.Book;

public class Main {
    public static void main(String[] args) {
        Fraction one = new Fraction(4);
        Fraction two = new Fraction(1,5);
        Fraction sum = Fraction.sum(one,two);

        Fraction.printFraction(sum);

    }
}
