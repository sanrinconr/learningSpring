package com.mercadolibre.consulting.model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "turns")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TurnModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDateTime f_entry;
    @Column(nullable = false)
    private LocalDateTime f_out;
    @Column(nullable = false)
    private Boolean attended;
    @ManyToOne
    @JoinColumn(name="id_professional")
    private ProfessionalModel professionalModel;

    @ManyToOne
    @JoinColumn(name="id_patient")
    private PatientModel patientModel;
}
