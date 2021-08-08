package com.mercadolibre.consulting.repository;

import com.mercadolibre.consulting.enums.TurnStatus;
import com.mercadolibre.consulting.model.TurnModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurnRepository extends MongoRepository<TurnModel, String> {
    @Query("{status: 'PENDING'}")
    List<TurnModel> findAllPendingTurns();

    @Query("{$and:[{'professionalModel._id':?0},{'status':'PENDING'}]}")
    List<TurnModel> getPendientTurnsOfProfessional(String dniProfessional);

    @Query("{status: ?0}")
    List<TurnModel> findAllByStatus(TurnStatus status);

    @Query("{$and:[{'professionalModel._id':?0},{'status':?1}]}")
    List<TurnModel> getAllTurnsOfProfessionalStatus(String dniProfessional, String turnStatus);

}
