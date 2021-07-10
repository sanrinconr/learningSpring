package com.linkTracker.repository;

import com.linkTracker.exception.exception.LinkAlreadyExistsException;
import com.linkTracker.model.LinkModel;

public interface ILinkRepository {
    void insertLink(LinkModel linkModel) throws LinkAlreadyExistsException;
    void setLinkAsInvalid(LinkModel linkModel);
    void findLinkById(String id);
}
