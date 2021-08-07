package com.mercadolibre.consulting.dataGenerators.patient;

import com.mercadolibre.consulting.model.PatientModel;

public class PatientGenerator {
    public static PatientModel generateOne(){
        return PatientModel.builder()
                .name("A")
                .last_name("B")
                .dni("321").build();
    }
}
