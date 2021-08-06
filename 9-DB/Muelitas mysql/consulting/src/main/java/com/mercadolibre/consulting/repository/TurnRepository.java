package com.mercadolibre.consulting.repository;

import com.mercadolibre.consulting.model.PatientModel;
import com.mercadolibre.consulting.model.TurnModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TurnRepository extends JpaRepository<TurnModel, Long> {
    @Query("SELECT t FROM TurnModel t where t.professionalModel.id = :id  ")
    List<TurnModel> findTurnsOfAProfessional(@Param("id") Long id);
}
