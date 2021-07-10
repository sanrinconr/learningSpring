package com.linkTracker.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.linkTracker.LinkTrackerApplication;
import com.linkTracker.exception.exception.LinkAlreadyExistsException;
import com.linkTracker.model.LinkModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepositoryImp implements ILinkRepository{

    private final String NAME = "test.json";
    final Logger logger = LoggerFactory.getLogger(LinkTrackerApplication.class);
    @Override
    public void insertLink(LinkModel link) throws LinkAlreadyExistsException {
        List<LinkModel> links = loadDatabase();
        if(linkAlreadyExists(link)) throw new LinkAlreadyExistsException("Link with url "+link.getUrl()+" and name "+link.getName()+" already exists");
        links.add(link);
        saveDatabase(links);
    }

    @Override
    public void setLinkAsInvalid(LinkModel link) {
    }

    @Override
    public void findLinkById(String id) {

    }

    public boolean linkAlreadyExists(LinkModel linkModel){
        logger.info(linkModel.getId());
        List<LinkModel> data = loadDatabase();
        if(data.size() == 0) return false;
        for(LinkModel modelDB: data){

            if(modelDB.getId().equals(linkModel.getId())){
                return true;
            }
        }
        return false;
    }

    private List<LinkModel> loadDatabase(){
        File file = null;
        try {
            file = new File(NAME);
            if (file.createNewFile()) {
                logger.info("File created: " + file.getName());
            }
        } catch (IOException e) {
            logger.warn("An error occurred");
            e.printStackTrace();
        }

        return mapObject(file);
    }
    private List<LinkModel> mapObject(File file){
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<LinkModel>> typeReference = new TypeReference<>(){};
        List<LinkModel> actorModels;
        try {
            actorModels = objectMapper.readValue(file, typeReference);
        }catch (IOException e){
            logger.error("Cant read json "+e.getMessage());
            actorModels = new ArrayList<>();
        }
        return actorModels;
    }

    private void saveDatabase(List<LinkModel> linkModels){
        try {
            File file = new File(NAME);
            if(file.createNewFile()) logger.info("Created file db!");
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file,linkModels);
            logger.info("Models wrote to db!");
        } catch (Exception e) {
            logger.warn("error occurred when writing to db");
            e.printStackTrace();
        }
    }
}
