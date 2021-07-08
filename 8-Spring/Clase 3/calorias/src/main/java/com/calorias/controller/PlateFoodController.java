package com.calorias.controller;

import com.calorias.dto.request.IngredientRequestDTO;
import com.calorias.dto.request.PlateFoodRequestDTO;
import com.calorias.dto.response.IngredientCalorieResponseDTO;
import com.calorias.dto.response.PlateCaloriesResponseDTO;
import com.calorias.exception.IngredientNotExistException;
import com.calorias.service.IPlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/plateFood")
public class PlateFoodController {
    @Autowired
    IPlateService plateService;
    @PostMapping("/totalCalorie")
    public ResponseEntity<PlateCaloriesResponseDTO> getTotalCaloriePlate(@Valid @RequestBody PlateFoodRequestDTO plateFoodRequestDTO) throws IngredientNotExistException {
        return new ResponseEntity<>(plateService.getTotalCalories(plateFoodRequestDTO), HttpStatus.OK);
    }

    @PostMapping("/caloriePerIngredient")
    public ResponseEntity<List<IngredientCalorieResponseDTO>> getCaloriesPerIngredient(@Valid @RequestBody PlateFoodRequestDTO plateFoodRequestDTO) throws IngredientNotExistException {
        return new ResponseEntity<>(plateService.getIndividualCalories(plateFoodRequestDTO), HttpStatus.OK);
    }
    @PostMapping("/moreCaloricIngredient")
    public ResponseEntity<IngredientCalorieResponseDTO> getMoreCaloricIngredient(@Valid @RequestBody PlateFoodRequestDTO plateFoodRequestDTO) throws IngredientNotExistException {
        return new ResponseEntity<IngredientCalorieResponseDTO>(plateService.getMoreCaloricIngredient(plateFoodRequestDTO), HttpStatus.OK);
    }

}
