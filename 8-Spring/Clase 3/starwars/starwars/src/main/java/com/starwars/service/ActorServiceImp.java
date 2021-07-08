package com.starwars.service;

import com.starwars.dto.response.ActorResponseDTO;
import com.starwars.exception.exceptions.ActorNotFoundException;
import com.starwars.model.ActorModel;
import com.starwars.repository.IActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImp implements IActorService {
    private IActorRepository iActorRepository;

    @Autowired
    public ActorServiceImp(IActorRepository iActorRepository) {
        this.iActorRepository = iActorRepository;
    }
    @Override
    public ActorResponseDTO findActorCoincidenceWithName(String name) throws ActorNotFoundException {
        List<ActorModel> actorModelList = iActorRepository.findAll();
        for(ActorModel actor:actorModelList){
            if(actor.getName().toLowerCase().contains(name.toLowerCase())){
                return new ActorResponseDTO(actor.getName());
            }
        }
        throw new ActorNotFoundException("That actor dont exists");
    }
}
