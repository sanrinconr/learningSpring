package com.starwars.repository;

import com.starwars.model.ActorModel;

import java.util.List;

public interface IActorRepository {
    List<ActorModel> findAll();
}
