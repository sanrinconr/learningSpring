package com.mercadolibre.consulting.repository;

import com.mercadolibre.consulting.model.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientModel, Long> {
}
