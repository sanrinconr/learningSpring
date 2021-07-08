package com.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.model.ActorModel;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
@Repository
public class ActorRepositoryImp implements IActorRepository{
    @Override
    public List<ActorModel> findAll() {
        return loadDatabase();
    }

    private List<ActorModel> loadDatabase(){
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:static/starwars.json");

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        return mapObject(file);
    }
    private List<ActorModel> mapObject(File file){
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<ActorModel>> typeReference = new TypeReference<>(){};
        List<ActorModel> actorModels = null;
        try {
            actorModels = objectMapper.readValue(file, typeReference);
        }catch (IOException e){
            e.printStackTrace();
        }
        return actorModels;
    }
}
