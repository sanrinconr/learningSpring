package com.fraction;

public class Fraction {
    private int num;
    private int den;

    public Fraction(int num, int den){
        this.num = num;
        this.den = den;
    }
    public Fraction(int num){
        this.num = num;
        this.den = 1;
    }

    public int getNum() {
        return num;
    }

    public int getDen() {
        return den;
    }

    public static Fraction sum(Fraction one, Fraction two){
        int denRes = one.getDen() * two.getDen();
        int numRes = (one.getNum()* two.getDen()) + (one.getDen() * two.getNum());
        return new Fraction(numRes, denRes);
    }

    public static Fraction substraction(Fraction one, Fraction two){
        int denRes = one.getDen() * two.getDen();
        int numRes = (one.getNum()* two.getDen()) - (one.getDen() * two.getNum());
        return new Fraction(numRes, denRes);
    }

    public static Fraction multiply(Fraction one, Fraction two){
        int denRes = one.getDen() * two.getDen();
        int numRes = one.getNum() * two.getNum();
        return new Fraction(numRes, denRes);
    }
    public static Fraction divide(Fraction one, Fraction two){
        int denRes = one.getNum() * two.getDen();
        int numRes = two.getNum() * one.getDen();
        return new Fraction(numRes, denRes);
    }



    public static void printFraction(Fraction fraction){
        if(fraction.getDen() != 1) System.out.println(fraction.getNum()+"/"+ fraction.getDen());
        else System.out.println(fraction.getNum());
    }
}
