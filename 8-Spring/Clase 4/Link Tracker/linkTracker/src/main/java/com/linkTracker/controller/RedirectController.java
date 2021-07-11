package com.linkTracker.controller;

import com.linkTracker.dto.response.LinkRedirectResponseDTO;
import com.linkTracker.exception.exception.LinkInvalidException;
import com.linkTracker.exception.exception.LinkNotExistException;
import com.linkTracker.service.ILinkService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@SuppressWarnings("unused")
@RestControllerAdvice
@RequestMapping("/link")
public class RedirectController {
    final ILinkService linkService;

    public RedirectController(ILinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/{linkID}")
    public RedirectView redirectURL(@PathVariable String linkID, @RequestParam(required = false) String password) throws LinkNotExistException, LinkInvalidException {
        LinkRedirectResponseDTO a = linkService.getURLToRedirect(linkID, password);
        return new RedirectView(a.getUrl());
    }
}
