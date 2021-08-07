package com.mercadolibre.consulting.dataGenerators.professional;

import com.mercadolibre.consulting.enums.ProfessionalServices;
import com.mercadolibre.consulting.model.ProfessionalModel;

public class ProfessionalGenerator {
    public static ProfessionalModel generateOne(ProfessionalServices service){
        return ProfessionalModel.builder()
                .dni("123")
                .name("Camila")
                .last_name("Cortes")
                .service(service)
                .build();
    }
}
