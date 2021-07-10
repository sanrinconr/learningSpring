package com.linkTracker.service;

import com.linkTracker.dto.request.LinkCreateRequestDTO;
import com.linkTracker.dto.response.LinkCreatedResponseDTO;
import com.linkTracker.exception.exception.LinkAlreadyExistsException;

public interface ILinkService {
    LinkCreatedResponseDTO createURL(LinkCreateRequestDTO data) throws LinkAlreadyExistsException;
}
