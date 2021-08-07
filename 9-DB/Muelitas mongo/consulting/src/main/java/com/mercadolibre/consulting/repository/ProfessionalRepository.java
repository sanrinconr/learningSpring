package com.mercadolibre.consulting.repository;

import com.mercadolibre.consulting.enums.ProfessionalServices;
import com.mercadolibre.consulting.model.ProfessionalModel;

import com.mercadolibre.consulting.model.TurnModel;
import com.mercadolibre.consulting.service.ProfessionalService;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessionalRepository extends MongoRepository<ProfessionalModel, Long> {
    @Query("{service: ?0}")
    List<ProfessionalModel> findAllProfessionalsByService(ProfessionalServices service);
}
