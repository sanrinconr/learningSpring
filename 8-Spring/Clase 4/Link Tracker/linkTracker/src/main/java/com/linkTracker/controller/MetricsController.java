package com.linkTracker.controller;

import com.linkTracker.dto.response.LinkCreatedResponseDTO;
import com.linkTracker.dto.response.LinkMetricsResponseDTO;
import com.linkTracker.exception.exception.LinkNotExistException;
import com.linkTracker.service.ILinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metrics")
public class MetricsController {
    ILinkService linkService;

    public MetricsController(ILinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/{linkID}")
    public ResponseEntity<LinkMetricsResponseDTO> getMetrics(@PathVariable String linkID) throws LinkNotExistException {
        return new ResponseEntity<>(linkService.getMetricsLink(linkID), HttpStatus.OK);
    }
}
