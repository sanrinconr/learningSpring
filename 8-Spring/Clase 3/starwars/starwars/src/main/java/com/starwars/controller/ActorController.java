package com.starwars.controller;

import com.starwars.dto.response.ActorResponseDTO;
import com.starwars.exception.exceptions.ActorNotFoundException;
import com.starwars.service.ActorServiceImp;
import com.starwars.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ActorController {
    private IActorService actorService;

    @Autowired
    public ActorController(IActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public ResponseEntity<ActorResponseDTO> test(@RequestParam String name) throws ActorNotFoundException {
        return new ResponseEntity<>(actorService.findActorCoincidenceWithName(name), HttpStatus.OK);
    }
}
