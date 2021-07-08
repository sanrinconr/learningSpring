package com.calorias.service;

import com.calorias.dto.request.IngredientRequestDTO;
import com.calorias.dto.request.PlateFoodRequestDTO;
import com.calorias.dto.response.IngredientCalorieResponseDTO;
import com.calorias.dto.response.PlateCaloriesResponseDTO;
import com.calorias.exception.IngredientNotExistException;
import com.calorias.repository.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlateServiceImp implements IPlateService {
    @Autowired
    IFoodRepository foodRepository;

    @Override
    public PlateCaloriesResponseDTO getTotalCalories(PlateFoodRequestDTO plateFoodRequestDTO) throws IngredientNotExistException {
        int total = 0;
        List<IngredientRequestDTO> ingredientRequestDTOList = plateFoodRequestDTO.getIngredientRequestDTOList();
        for (IngredientRequestDTO in : ingredientRequestDTOList) {
            //The calories is calculated in base of 100 grams, for example if a ingredient have 200 Calories and is used 400Grs
            //Then the total calories is 800 Calories
            //800 = 200 * (400 / 100)
            int calories = foodRepository.findCaloriesByName(in.getName());
            double grams = in.getWeight();
            total += calories * grams / 100;
        }
        PlateCaloriesResponseDTO plateCaloriesResponseDTO = new PlateCaloriesResponseDTO();
        plateCaloriesResponseDTO.setName(plateFoodRequestDTO.getName());
        plateCaloriesResponseDTO.setCalories(total);
        return plateCaloriesResponseDTO;
    }

    @Override
    public List<IngredientCalorieResponseDTO> getIndividualCalories(PlateFoodRequestDTO plateFoodRequestDTO) throws IngredientNotExistException {
        List<IngredientCalorieResponseDTO> individualCalories = new ArrayList<IngredientCalorieResponseDTO>();
        for (IngredientRequestDTO in : plateFoodRequestDTO.getIngredientRequestDTOList()) {
            IngredientCalorieResponseDTO ingredientCalorieResponseDTO = new IngredientCalorieResponseDTO();
            ingredientCalorieResponseDTO.setName(in.getName());
            ingredientCalorieResponseDTO.setCalories(foodRepository.findCaloriesByName(in.getName()));
            individualCalories.add(ingredientCalorieResponseDTO);
        }
        return individualCalories;
    }

    @Override
    public IngredientCalorieResponseDTO getMoreCaloricIngredient(PlateFoodRequestDTO plateFoodRequestDTO) throws IngredientNotExistException {
        //Validations
        if (plateFoodRequestDTO.getIngredientRequestDTOList().size() <= 0)
            throw new IngredientNotExistException("No ingredient list provided in the plate");
        IngredientCalorieResponseDTO bigCaloricIngredient = null;

        //Logic
        for (IngredientRequestDTO in : plateFoodRequestDTO.getIngredientRequestDTOList()) {
            int caloriesNew, caloriesActual;
            if (bigCaloricIngredient != null) {
                caloriesNew = foodRepository.findCaloriesByName(in.getName());
                caloriesActual = foodRepository.findCaloriesByName(bigCaloricIngredient.getName());
                if(caloriesActual < caloriesNew){
                    bigCaloricIngredient = new IngredientCalorieResponseDTO(in.getName(), caloriesNew);
                }
            } else {
                bigCaloricIngredient = new IngredientCalorieResponseDTO(
                        in.getName(),
                        foodRepository.findCaloriesByName(in.getName())
                );
            }
        }
        return bigCaloricIngredient;
    }
}
