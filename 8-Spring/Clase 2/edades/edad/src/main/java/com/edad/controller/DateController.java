package com.edad.controller;

import com.edad.dto.request.DateRequestDTO;
import com.edad.dto.response.DateResponseDTO;
import com.edad.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class DateController {

    DateService dateService;

    @Autowired
    public DateController(DateService dateService) {
        this.dateService = dateService;
    }

    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity<DateResponseDTO> getAge(@PathVariable int day, @PathVariable int month, @PathVariable int year){
        DateRequestDTO dateRequestDTO = new DateRequestDTO(month,day,year);
        return new ResponseEntity<>(dateService.getAgeOfDate(dateRequestDTO), HttpStatus.OK);
    }
}
