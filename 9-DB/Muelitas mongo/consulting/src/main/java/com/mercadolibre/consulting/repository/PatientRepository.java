package com.mercadolibre.consulting.repository;

import com.mercadolibre.consulting.model.PatientModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends MongoRepository<PatientModel, String> {
    Optional<PatientModel> findById(String id);
}
