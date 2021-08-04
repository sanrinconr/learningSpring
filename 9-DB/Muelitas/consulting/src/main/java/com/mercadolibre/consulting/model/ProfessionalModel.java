package com.mercadolibre.consulting.model;

import com.mercadolibre.consulting.enums.ProfessionalServices;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "professionals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfessionalModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String last_name;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProfessionalServices service;

}
