package com.starwars.service;

import com.starwars.dto.response.ActorResponseDTO;
import com.starwars.exception.exceptions.ActorNotFoundException;
import org.springframework.stereotype.Repository;

public interface IActorService {
    ActorResponseDTO findActorCoincidenceWithName(String name) throws ActorNotFoundException;
}
