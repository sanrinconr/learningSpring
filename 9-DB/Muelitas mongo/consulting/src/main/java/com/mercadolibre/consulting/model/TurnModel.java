package com.mercadolibre.consulting.model;

import com.mercadolibre.consulting.enums.TurnStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@Document(collection = "turns")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TurnModel {
    @Id
    private String id;
    private LocalDateTime f_entry;
    private LocalDateTime f_out;
    private TurnStatus status;

    private ProfessionalModel professionalModel;

    private PatientModel patientModel;
}
