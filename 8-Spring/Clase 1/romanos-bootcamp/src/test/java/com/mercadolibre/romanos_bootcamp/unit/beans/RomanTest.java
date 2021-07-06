package com.mercadolibre.romanos_bootcamp.unit.beans;

import com.mercadolibre.romanos_bootcamp.beans.RandomSampleBean;
import com.mercadolibre.romanos_bootcamp.beans.service.RomanConversor.Roman;
import com.mercadolibre.romanos_bootcamp.dtos.SampleDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RomanTest {
    @Test
    public void numberToRomanOne() {
        int decimal = 1;
        Roman roman = new Roman(decimal);
        assertEquals(roman.getRoman() , "I");
    }
    @Test
    public void numberToRomanTwo() {
        int decimal = 2;
        Roman roman = new Roman(decimal);
        assertEquals(roman.getRoman() , "II");
    }
    @Test
    public void numberToRomanTen() {
        int decimal = 10;
        Roman roman = new Roman(decimal);
        assertEquals(roman.getRoman() , "X");
    }
    @Test
    public void numberToRomanEleven() {
        int decimal = 11;
        Roman roman = new Roman(decimal);
        assertEquals(roman.getRoman() , "XI");
    }
    @Test
    public void numberToRomanThirteen() {
        int decimal = 13;
        Roman roman = new Roman(decimal);
        assertEquals(roman.getRoman() , "XIII");
    }
    @Test
    public void numberToRomanMile() {
        int decimal = 1000;
        Roman roman = new Roman(decimal);
        assertEquals(roman.getRoman() , "M");
    }
}
