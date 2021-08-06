package com.mercadolibre.consulting.repository;

import com.mercadolibre.consulting.model.ProfessionalModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalRepository extends MongoRepository<ProfessionalModel, Long> {

}
