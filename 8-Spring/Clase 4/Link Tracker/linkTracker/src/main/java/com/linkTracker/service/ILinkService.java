package com.linkTracker.service;

import com.linkTracker.dto.request.LinkCreateRequestDTO;
import com.linkTracker.dto.response.*;
import com.linkTracker.exception.exception.LinkAlreadyExistsException;
import com.linkTracker.exception.exception.LinkInvalidException;
import com.linkTracker.exception.exception.LinkNotExistException;

@SuppressWarnings("JavaDoc")
public interface ILinkService {
    /**
     * Create a new URL
     * @param data
     * @return
     * @throws LinkAlreadyExistsException
     */
    LinkCreatedResponseDTO createURL(LinkCreateRequestDTO data) throws LinkAlreadyExistsException;

    /**
     * Obtain metrics with the numbers of clicks of a url
     * @param linkId
     * @return
     * @throws LinkNotExistException
     */
    LinkMetricsResponseDTO getMetricsLink(String linkId) throws LinkNotExistException;

    /**
     * Change the status of a URL to INVALID
     * @param linkID
     * @return
     * @throws LinkNotExistException
     */
    LinkInvalidatedResponseDTO invalidateURL(String linkID) throws LinkNotExistException;

    /**
     * Obtain the url of a id to redirect, in this  step the counter is incremented in one
     * @param id
     * @param password
     * @return
     * @throws LinkNotExistException
     */
    LinkRedirectResponseDTO getURLToRedirect(String id, String password) throws LinkNotExistException, LinkInvalidException;

}
