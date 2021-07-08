package com.calorias.repository;

import com.calorias.model.IngredientModel;
import com.calorias.dto.request.IngredientRequestDTO;
import com.calorias.exception.IngredientNotExistException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class FoodRepositoryImp implements IFoodRepository{
    @Override
    public int findCaloriesByName(String name) throws IngredientNotExistException {
        Optional<IngredientModel> optional = loadDatabase().stream().filter(x->x.getName().equals(name)).findFirst();
        if(optional.isEmpty()) throw new IngredientNotExistException("El ingredient "+name+ " aun no existe en la base de datos");

        return optional.get().getCalories();
    }

    public List<IngredientModel> loadDatabase(){
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:static/food.json");

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        return mapObject(file);
    }

    private List<IngredientModel> mapObject(File file){
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredientModel>> typeReference = new TypeReference<>(){};
        List<IngredientModel> ingredientModels = null;
        try {
            ingredientModels = objectMapper.readValue(file, typeReference);
        }catch (IOException e){
            e.printStackTrace();
        }
        return ingredientModels;
    }
}
