package com.metroCuadrado.controller;

import com.metroCuadrado.dto.response.HouseSquareMetersDTO;
import com.metroCuadrado.dto.response.HouseValueDTO;
import com.metroCuadrado.dto.response.RoomMetersDTO;
import com.metroCuadrado.model.HouseModel;
import com.metroCuadrado.model.RoomModel;
import com.metroCuadrado.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    HouseService houseService;

    @PostMapping
    public ResponseEntity<HouseModel> test(@Valid @RequestBody HouseModel houseModel) {
        return new ResponseEntity<HouseModel>(houseModel, HttpStatus.OK);
    }

    @PostMapping("/squareMeters")
    public ResponseEntity<HouseSquareMetersDTO> getTotalMeters(@Valid @RequestBody HouseModel houseModel) {
        return new ResponseEntity<>(houseService.getHouseTotalSquareMeters(houseModel), HttpStatus.OK);
    }

    @PostMapping("/value")
    public ResponseEntity<HouseValueDTO> getPrice(@Valid @RequestBody HouseModel houseModel) {
        return new ResponseEntity<>(houseService.getHouseValue(houseModel), HttpStatus.OK);
    }

    @PostMapping("/biggerRoom")
    public ResponseEntity<RoomModel> getBiggerRoom(@Valid @RequestBody HouseModel houseModel) {
        return new ResponseEntity<>(houseService.getBiggerRoom(houseModel), HttpStatus.OK);
    }

    @PostMapping("/metersPerRoom")
    public ResponseEntity<List<RoomMetersDTO>> getMetersPerRoom(@Valid @RequestBody HouseModel houseModel) {
        return new ResponseEntity<>(houseService.getMetersPerRoom(houseModel), HttpStatus.OK);
    }

}
