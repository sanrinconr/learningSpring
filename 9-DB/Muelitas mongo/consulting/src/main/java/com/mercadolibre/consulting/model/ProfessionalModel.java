package com.mercadolibre.consulting.model;

import com.mercadolibre.consulting.enums.ProfessionalServices;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "professionals")

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfessionalModel {
    @Id
    private String dni;
    private String name;
    private String last_name;
    private ProfessionalServices service;

}
