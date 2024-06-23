package net.planetroettger.macronutrients.service;

import lombok.AllArgsConstructor;
import net.planetroettger.macronutrients.persistence.model.FoodDao;
import net.planetroettger.macronutrients.persistence.repository.FoodRepository;
import net.planetroettger.macronutrients.transformer.FoodDaoTransformer;
import net.planetroettger.macronutrients.types.FoodDto;
import net.planetroettger.macronutrients.types.FoodInput;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodDto addFood(FoodInput food) {
        FoodDao foodDao = FoodDaoTransformer.transformInputToDao(food);
        foodDao = foodRepository.save(foodDao);
        return FoodDaoTransformer.transformDaoToDto(foodDao);
    }

    public List<FoodDto> getAllFoods() {
        return foodRepository.findAll().stream().map(FoodDaoTransformer::transformDaoToDto).toList();
    }
}