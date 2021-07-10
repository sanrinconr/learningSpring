package com.linkTracker.controller;

import com.linkTracker.dto.request.LinkCreateRequestDTO;
import com.linkTracker.dto.response.LinkCreatedResponseDTO;
import com.linkTracker.exception.exception.LinkAlreadyExistsException;
import com.linkTracker.service.ILinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/createURL")
public class CreateURLController {

    final ILinkService linkService;

    public CreateURLController(ILinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping
    public ResponseEntity<LinkCreatedResponseDTO> createURL(@Valid @RequestBody LinkCreateRequestDTO data) throws LinkAlreadyExistsException {
        return new ResponseEntity<>(linkService.createURL(data), HttpStatus.OK);
    }
}
