package com.mercadolibre.consulting.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "professionals")
@Data
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
    @Column(nullable = false)
    private String service;

    @OneToMany(mappedBy = "professionalModel",cascade = CascadeType.ALL)
    private List<TurnModel> turns;
}
