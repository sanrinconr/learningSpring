package com.mercadolibre.consulting.repository;

import com.mercadolibre.consulting.model.TurnModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnRepository extends MongoRepository<TurnModel, Long> {
    /*@Query("SELECT t FROM TurnModel t where t.professionalModel.id = :id  ")
    @Query("{'turns':")
    List<TurnModel> findTurnsOfAProfessional(Long id);*/
}
