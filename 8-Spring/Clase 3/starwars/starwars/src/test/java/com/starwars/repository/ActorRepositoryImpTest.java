package com.starwars.repository;

import com.starwars.model.ActorModel;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ActorRepositoryImpTest {
    @Test
    public void obtainData(){
        ActorRepositoryImp actorRepositoryImp = new ActorRepositoryImp();
        List<ActorModel> actorModels = actorRepositoryImp.findAll();
        for(ActorModel actorModel:actorModels){
            System.out.print(actorModel.getName());
        }
    }
}
