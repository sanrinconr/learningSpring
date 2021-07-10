package com.linkTracker.repository;

import com.linkTracker.exception.exception.LinkAlreadyExistsException;
import com.linkTracker.exception.exception.LinkNotExistException;
import com.linkTracker.model.LinkModel;

public interface ILinkRepository {
    void insertLink(LinkModel linkModel) throws LinkAlreadyExistsException;
    void setLinkAsInvalid(LinkModel linkModel);
    String findLinkById(String id, String password) throws LinkNotExistException;
    LinkModel findModelById(String id) throws LinkNotExistException;
}
