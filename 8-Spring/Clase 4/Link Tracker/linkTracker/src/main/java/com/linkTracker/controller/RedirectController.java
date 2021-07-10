package com.linkTracker.controller;

import com.linkTracker.exception.exception.LinkNotExistException;
import com.linkTracker.service.ILinkService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestControllerAdvice
@RequestMapping("/link")
public class RedirectController {
    final ILinkService linkService;

    public RedirectController(ILinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/{linkID}")
    public RedirectView redirectURL(@PathVariable String linkID, @RequestParam(required = false) String password) throws LinkNotExistException {
        return new RedirectView(linkService.getURLById(linkID, password));
    }
}
