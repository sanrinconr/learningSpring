package com.linkTracker.service;

import com.linkTracker.dto.request.LinkCreateRequestDTO;
import com.linkTracker.dto.response.LinkCreatedResponseDTO;
import com.linkTracker.dto.response.LinkMetricsResponseDTO;
import com.linkTracker.exception.exception.LinkAlreadyExistsException;
import com.linkTracker.exception.exception.LinkNotExistException;

public interface ILinkService {
    LinkCreatedResponseDTO createURL(LinkCreateRequestDTO data) throws LinkAlreadyExistsException;
    String getURLById(String id, String password) throws LinkNotExistException;
    LinkMetricsResponseDTO getMetricsLink(String linkId) throws LinkNotExistException;
}
