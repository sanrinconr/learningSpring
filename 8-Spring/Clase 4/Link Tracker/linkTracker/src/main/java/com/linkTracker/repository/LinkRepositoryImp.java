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
import java.util.Optional;

@SuppressWarnings("unused")
@Repository
public class LinkRepositoryImp implements ILinkRepository {

    private final String NAME = "test.json";
    final Logger logger = LoggerFactory.getLogger(LinkTrackerApplication.class);


    @Override
    public LinkModel insertLink(LinkModel link) throws LinkAlreadyExistsException {
        List<LinkModel> links = loadDatabase();
        if (linkAlreadyExists(link))
            throw new LinkAlreadyExistsException(link.getUrl(), link.getName());
        links.add(link);
        saveDatabase(links);
        return link;
    }


    @Override
    public LinkModel modifyLink(LinkModel linkModel) throws LinkNotExistException {
        List<LinkModel> links = loadDatabase();
        for(int i = 0; i< links.size() ; i++){
            if(links.get(i).getLinkID().equals(linkModel.getLinkID())){
                links.set(i, linkModel);
                this.saveDatabase(links);
                return links.get(i);
            }
        }
        throw new LinkNotExistException(linkModel.getLinkID());
    }


    @Override
    public LinkModel setLinkAsInvalid(LinkModel link) throws LinkNotExistException {
        List<LinkModel> links = loadDatabase();
        Optional<LinkModel> candidate = links.stream().filter(x -> x.getLinkID().equals(link.getLinkID())).findAny();
        if(candidate.isEmpty()) throw new LinkNotExistException(link.getLinkID());
        LinkModel funded = candidate.get();
        funded.setStatus("INVALID");
        this.saveDatabase(links);
        return funded;
    }


    @Override
    public LinkModel findModelByIdUSER(String id, String password) throws LinkNotExistException {
        List<LinkModel> links = loadDatabase();
        for (LinkModel model : links) {
            //If password not exist only validate id
            if (password == null && model.getPassword() == null) {
                if (model.getLinkID().equals(id)) {
                    return model;
                }
                //Else, find same id and password
            } else {
                if (model.getPassword() != null && model.getPassword().equals(password)) {
                    if (model.getLinkID().equals(id)) {
                        return model;
                    }
                }
            }

        }
        throw new LinkNotExistException(id);
    }



    @Override
    public LinkModel findModelByIdADMIN(String id) throws LinkNotExistException {
        List<LinkModel> links = loadDatabase();
        for (LinkModel model : links) {
            if (model.getLinkID().equals(id)) {
                return model;
            }
        }
        throw new LinkNotExistException(id);
    }

    @Override
    public LinkModel incrementCounterURL(String id) throws LinkNotExistException {
        LinkModel model = this.findModelByIdADMIN(id);
        model.incrementTimesClicked();
        return this.modifyLink(model);
    }

    private boolean linkAlreadyExists(LinkModel linkModel) {
        List<LinkModel> data = loadDatabase();
        if (data.size() == 0) return false;
        for (LinkModel modelDB : data) {

            if (modelDB.getLinkID().equals(linkModel.getLinkID())) {
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
            logger.error("Cant read json (probably is empty) full error: " + e.getMessage());
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
            logger.warn("Error occurred when writing to db");
            e.printStackTrace();
        }
    }
}
