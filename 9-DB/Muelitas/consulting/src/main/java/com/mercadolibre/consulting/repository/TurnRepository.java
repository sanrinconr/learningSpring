package com.mercadolibre.consulting.repository;

import com.mercadolibre.consulting.model.TurnModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurnRepository extends JpaRepository<TurnModel, Long> {
}
