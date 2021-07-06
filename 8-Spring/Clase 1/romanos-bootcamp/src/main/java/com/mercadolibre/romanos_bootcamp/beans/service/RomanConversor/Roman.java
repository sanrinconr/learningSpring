package com.mercadolibre.romanos_bootcamp.beans.service.RomanConversor;

import org.springframework.stereotype.Service;


public class Roman {
    private String roman;

    public Roman(int decimal) {
        this.roman = Roman.decimalToRoman(decimal);
    }

    public static String decimalToRoman(int number) {
        String out = "";
        while (number > 0) {
            if (number >= 1000) {
                number = number % 1000;
                out =out +  "M";
            } else if (number >= 900) {
                number = number % 900;
                out = out + "CM";
            } else if (number >= 500) {
                number = number % 500;
                out =out +  "D";
            } else if (number >= 400) {
                number = number % 400;
                out = out + "CD";
            } else if (number >= 100) {
                number = number % 100;
                out =out +  "C";
            } else if (number >= 90) {
                number = number % 90;
                out = out + "XC";
            } else if (number >= 50) {
                number = number % 50;
                out =out +  "L";
            } else if (number >= 40) {
                number = number % 40;
                out = out + "XL";
            } else if (number >= 10) {
                number = number % 10;
                out =out +  "X";
            } else if (number >= 9) {
                number = number % 9;
                out = out + "IX";
            } else if (number >= 5) {
                number = number % 5;
                out =out +  "V";
            } else if (number >= 4) {
                number = number % 4;
                out = out + "IV";
            } else if (number >= 1) {
                if(number == 3){
                    out = out + "III";
                }
                if(number == 2){
                    out = out + "II";
                }
                if(number == 1){
                    out=out +  "I";
                }
                number = number % 1;
            }
        }
        return out;
    }


    public String getRoman() {
        return roman;
    }
}
