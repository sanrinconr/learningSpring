package com.mercadolibre.consulting.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Document(collection = "patients")

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientModel {
    @Id
    private String dni;
    private String name;
    private String last_name;
}
