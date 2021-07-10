package com.linkTracker.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.linkTracker.LinkTrackerApplication;
import com.linkTracker.exception.exception.LinkAlreadyExistsException;
import com.linkTracker.exception.exception.LinkNotExistException;
import com.linkTracker.model.LinkModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepositoryImp implements ILinkRepository {

    private final String NAME = "test.json";
    final Logger logger = LoggerFactory.getLogger(LinkTrackerApplication.class);

    @Override
    public void insertLink(LinkModel link) throws LinkAlreadyExistsException {
        List<LinkModel> links = loadDatabase();
        if (linkAlreadyExists(link))
            throw new LinkAlreadyExistsException("Link with url " + link.getUrl() + " and name " + link.getName() + " already exists");
        links.add(link);
        saveDatabase(links);
    }

    @Override
    public void setLinkAsInvalid(LinkModel link) {
    }

    @Override
    public String findLinkById(String id, String password) throws LinkNotExistException {
        List<LinkModel> links = loadDatabase();
        for (LinkModel model : links) {
            //If password not exist only validate id
            if (password == null && model.getPassword() == null) {
                if (model.getId().equals(id)) {
                    return model.getUrl();
                }
                //Else, find same id and password
            } else {
                if (model.getPassword() != null && model.getPassword().equals(password)) {
                    if (model.getId().equals(id)) {
                        return model.getUrl();
                    }
                }
            }

        }
        throw new LinkNotExistException("The id " + id + " not exist (you mistake the password?)");
    }

    @Override
    public LinkModel findModelById(String id) throws LinkNotExistException {
        List<LinkModel> links = loadDatabase();
        for (LinkModel model : links) {
            //If password not exist only validate id

            if (model.getId().equals(id)) {
                return model;
            }
            //Else, find same id and password


        }
        throw new LinkNotExistException("The id " + id + " not exist");
    }

    public boolean linkAlreadyExists(LinkModel linkModel) {
        List<LinkModel> data = loadDatabase();
        if (data.size() == 0) return false;
        for (LinkModel modelDB : data) {

            if (modelDB.getId().equals(linkModel.getId())) {
                return true;
            }
        }
        return false;
    }

    private List<LinkModel> loadDatabase() {
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

    private List<LinkModel> mapObject(File file) {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<LinkModel>> typeReference = new TypeReference<>() {
        };
        List<LinkModel> actorModels;
        try {
            actorModels = objectMapper.readValue(file, typeReference);
        } catch (IOException e) {
            logger.error("Cant read json (probaby is empty) full error: " + e.getMessage());
            actorModels = new ArrayList<>();
        }
        return actorModels;
    }

    private void saveDatabase(List<LinkModel> linkModels) {
        try {
            File file = new File(NAME);
            if (file.createNewFile()) logger.info("Created file db!");
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, linkModels);
            logger.info("Models wrote to db!");
        } catch (Exception e) {
            logger.warn("error occurred when writing to db");
            e.printStackTrace();
        }
    }
}
