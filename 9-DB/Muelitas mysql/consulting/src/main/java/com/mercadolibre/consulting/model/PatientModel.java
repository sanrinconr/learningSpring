package com.mercadolibre.consulting.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "patients")
@Getter
@Setter
@Data@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String last_name;

}
