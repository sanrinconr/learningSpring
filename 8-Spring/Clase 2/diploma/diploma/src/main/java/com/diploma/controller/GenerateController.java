package com.diploma.controller;

import com.diploma.dto.request.StudentAssignsDTO;
import com.diploma.dto.response.CertificateResponseDTO;
import com.diploma.service.GenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/generate")
public class GenerateController {
    @Autowired
    GenerateService generateService;
    @PostMapping
    public ResponseEntity<CertificateResponseDTO> generateCertification(@RequestBody @Valid StudentAssignsDTO studentAssignsDTO){
        return new ResponseEntity<>(generateService.generateCertificate(studentAssignsDTO), HttpStatus.OK);
    }
}
