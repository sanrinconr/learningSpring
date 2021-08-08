package com.mercadolibre.consulting.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "patients")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientModel {
    @Id
    private String dni;
    private String name;
    private String last_name;
}
