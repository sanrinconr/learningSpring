package com.calorias.service;

import com.calorias.dto.request.IngredientRequestDTO;
import com.calorias.dto.request.PlateFoodRequestDTO;
import com.calorias.dto.response.IngredientCalorieResponseDTO;
import com.calorias.dto.response.PlateCaloriesResponseDTO;
import com.calorias.exception.IngredientNotExistException;

import java.util.List;

public interface IPlateService {
    PlateCaloriesResponseDTO getTotalCalories(PlateFoodRequestDTO plateFoodRequestDTO) throws IngredientNotExistException;
    List<IngredientCalorieResponseDTO> getIndividualCalories(PlateFoodRequestDTO plateFoodRequestDTO) throws IngredientNotExistException;
    IngredientCalorieResponseDTO getMoreCaloricIngredient(PlateFoodRequestDTO plateFoodRequestDTO) throws IngredientNotExistException;
}
