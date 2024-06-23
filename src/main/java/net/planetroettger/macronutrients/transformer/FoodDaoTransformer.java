package net.planetroettger.macronutrients.transformer;

import net.planetroettger.macronutrients.persistence.model.FoodDao;
import net.planetroettger.macronutrients.types.FoodDto;
import net.planetroettger.macronutrients.types.FoodInput;
import org.springframework.stereotype.Component;

@Component
public class FoodDaoTransformer {

    public static FoodDao transformInputToDao(FoodInput foodInput) {
        FoodDao foodDao = new FoodDao();
        foodDao.setBrand(foodInput.getBrand());
        foodDao.setName(foodInput.getName());
        return foodDao;
    }

    public static FoodDto transformDaoToDto(FoodDao foodDao) {
        FoodDto foodDto = new FoodDto();
        foodDto.setId(foodDao.getId().toString());
        foodDto.setBrand(foodDao.getBrand());
        foodDto.setName(foodDao.getName());
        return foodDto;
    }
}