package net.planetroettger.macronutrients.service;

import lombok.AllArgsConstructor;
import net.planetroettger.macronutrients.persistence.model.FoodDao;
import net.planetroettger.macronutrients.persistence.repository.FoodRepository;
import net.planetroettger.macronutrients.transformer.FoodDaoTransformer;
import net.planetroettger.macronutrients.types.FoodDto;
import net.planetroettger.macronutrients.types.FoodInput;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodDto addFood(FoodInput food) {
        validateFoodInput(food);
        FoodDao foodDao = FoodDaoTransformer.transformInputToDao(food);
        return FoodDaoTransformer.transformDaoToDto(foodRepository.save(foodDao));
    }

    void validateFoodInput(FoodInput food) {
        if (StringUtils.isBlank(food.getName())) {
            throw new IllegalArgumentException("Food name '" + food.getName() + "' must contain more than whitespace.");
        }

        if (StringUtils.isBlank(food.getBrand())) {
            throw new IllegalArgumentException("Food brand '" + food.getBrand() + "' must contain more than whitespace.");
        }

        food.setBrand(StringUtils.trim(food.getBrand()));
        food.setName(StringUtils.trim(food.getName()));

        if (foodRepository.existsByNameAndBrand(food.getName(), food.getBrand())) {
            throw new IllegalArgumentException("Food with name '" + food.getName() + "' and brand '" + food.getBrand() + "' already exists.");
        }
    }

    public List<FoodDto> getAllFoods() {
        return foodRepository.findAll().stream().map(FoodDaoTransformer::transformDaoToDto).toList();
    }
}