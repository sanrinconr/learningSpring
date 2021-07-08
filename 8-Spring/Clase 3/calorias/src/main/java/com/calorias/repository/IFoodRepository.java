package com.calorias.repository;


import com.calorias.model.IngredientModel;
import com.calorias.exception.IngredientNotExistException;

import java.util.List;

public interface IFoodRepository {
    int findCaloriesByName(String name) throws IngredientNotExistException;
    List<IngredientModel> loadDatabase();
}
