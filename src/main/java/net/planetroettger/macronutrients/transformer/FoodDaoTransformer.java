package net.planetroettger.macronutrients.transformer;

import net.planetroettger.macronutrients.persistence.model.FoodDao;
import net.planetroettger.macronutrients.types.FoodDto;
import net.planetroettger.macronutrients.types.FoodInput;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

@Component
public class FoodDaoTransformer {

    public static FoodDao transformInputToDao(FoodInput foodInput) {
        FoodDao foodDao = new FoodDao();
        foodDao.setBrand(foodInput.getBrand());
        foodDao.setName(foodInput.getName());
        foodDao.setProtein(NumberUtils.toScaledBigDecimal(foodInput.getProtein()));
        foodDao.setFat(NumberUtils.toScaledBigDecimal(foodInput.getFat()));
        foodDao.setCarb(NumberUtils.toScaledBigDecimal(foodInput.getCarb()));
        foodDao.setFiber(NumberUtils.toScaledBigDecimal(foodInput.getFiber()));
        foodDao.setCalories(NumberUtils.toScaledBigDecimal(foodInput.getCalories()));
        foodDao.setServingAmount(NumberUtils.toScaledBigDecimal(foodInput.getServingAmount()));
        foodDao.setServingUnit(ServingUnitConverter.toDao(foodInput.getServingUnit()));
        foodDao.setServingSize(ServingSizeConverter.toDao(foodInput.getServingSize()));
        return foodDao;
    }

    public static FoodDto transformDaoToDto(FoodDao foodDao) {
        FoodDto foodDto = new FoodDto();
        foodDto.setId(foodDao.getId().toString());
        foodDto.setBrand(foodDao.getBrand());
        foodDto.setName(foodDao.getName());
        foodDto.setProtein(NumberUtils.toDouble(foodDao.getProtein()));
        foodDto.setFat(NumberUtils.toDouble(foodDao.getFat()));
        foodDto.setCarb(NumberUtils.toDouble(foodDao.getCarb()));
        foodDto.setFiber(NumberUtils.toDouble(foodDao.getFiber()));
        foodDto.setCalories(NumberUtils.toDouble(foodDao.getCalories()));
        foodDto.setServingAmount(NumberUtils.toDouble(foodDao.getServingAmount()));
        foodDto.setServingUnit(ServingUnitConverter.toDto(foodDao.getServingUnit()));
        foodDto.setServingSize(ServingSizeConverter.toDto(foodDao.getServingSize()));
        return foodDto;
    }
}
