package com.linkTracker.repository;

import com.linkTracker.exception.exception.LinkAlreadyExistsException;
import com.linkTracker.exception.exception.LinkNotExistException;
import com.linkTracker.model.LinkModel;

@SuppressWarnings("JavaDoc")
public interface ILinkRepository {
    /**
     * Create  a new link, if  a id already exists a exception going to be generated
     * @param linkModel
     * @return
     * @throws LinkAlreadyExistsException
     */
    LinkModel insertLink(LinkModel linkModel) throws LinkAlreadyExistsException;

    /**
     * Modify the params of a link, all params except the id
     * @param linkModel
     * @return
     * @throws LinkNotExistException
     */
    LinkModel modifyLink(LinkModel linkModel) throws  LinkNotExistException;

    /**
     * Change the para of valid in the model to INVALID
     * @param linkModel
     * @return
     * @throws LinkNotExistException
     */
    LinkModel setLinkAsInvalid(LinkModel linkModel) throws LinkNotExistException;

    /**
     * Find model by the id and the password, if the id is correct but the password no, a throw exception is generated
     * @param id of the URL
     * @param password of the URL
     * @return
     * @throws LinkNotExistException
     */
    LinkModel findModelByIdUSER(String id, String password) throws LinkNotExistException;

    /**
     * Search for a model regardless of whether or not it has a password
     * @param id Id of link
     * @return found link
     * @throws LinkNotExistException
     */
    LinkModel findModelByIdADMIN(String id) throws LinkNotExistException;

    /**
     * Add +1 the counter of the URL with the id provided
     * @param id
     * @return
     * @throws LinkNotExistException
     */
    LinkModel incrementCounterURL(String id) throws LinkNotExistException;
}
