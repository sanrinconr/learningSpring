package com.linkTracker.controller;

import com.linkTracker.dto.response.LinkInvalidatedResponseDTO;
import com.linkTracker.exception.exception.LinkNotExistException;
import com.linkTracker.service.ILinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/invalidate")
public class InvalidateController {
    final ILinkService linkService;

    public InvalidateController(ILinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/{linkID}")
    public ResponseEntity<LinkInvalidatedResponseDTO> invalidateURL(@PathVariable String linkID) throws LinkNotExistException {
        return new ResponseEntity<>(linkService.invalidateURL(linkID), HttpStatus.OK);
    }
}
