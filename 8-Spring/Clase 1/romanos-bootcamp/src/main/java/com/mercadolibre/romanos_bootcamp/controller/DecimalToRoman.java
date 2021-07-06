package com.mercadolibre.romanos_bootcamp.controller;

import com.mercadolibre.romanos_bootcamp.beans.service.RomanConversor.Roman;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/decimalToRoman")
public class DecimalToRoman {

    @GetMapping
    public ResponseEntity<Roman> convertDecimalToRoman(@RequestParam String decimal){
        Roman roman = new Roman(Integer.parseInt(decimal));
        return new ResponseEntity<>(roman, HttpStatus.OK);
    }

}
