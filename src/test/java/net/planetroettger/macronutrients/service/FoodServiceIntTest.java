package net.planetroettger.macronutrients.service;

import net.planetroettger.macronutrients.persistence.repository.FoodRepository;
import net.planetroettger.macronutrients.types.FoodDto;
import net.planetroettger.macronutrients.types.FoodInput;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ActiveProfiles("test")
class FoodServiceIntTest {

    @Autowired
    private FoodService foodService;

    @Autowired
    private FoodRepository foodRepository;

    @AfterEach
    void tearDown() {
        foodRepository.deleteAll();
    }

    @Test
    void addFood_alreadyExists_throwsException() {
        FoodInput foodInput = new FoodInput();
        foodInput.setBrand("Trader Joe's");
        foodInput.setName("Peanut Butter");

        // Add the food item to the repository
        foodService.addFood(foodInput);

        // Try to add the same food item again
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            foodService.addFood(foodInput);
        });

        String expectedMessage = "Food with name '" + foodInput.getName() + "' and brand '" + foodInput.getBrand() + "' already exists.";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void getAllFoods() {
        FoodInput foodInput = new FoodInput();
        foodInput.setBrand("Trader Joe's");
        foodInput.setName("Peanut Butter");
        foodService.addFood(foodInput);

        foodInput.setBrand("Silk");
        foodInput.setName("Almond Milk");
        foodService.addFood(foodInput);

        List<FoodDto> result = foodService.getAllFoods();

        assertEquals(2, result.size());
        assertEquals("Trader Joe's", result.get(0).getBrand());
        assertEquals("Peanut Butter", result.get(0).getName());
        assertEquals("Silk", result.get(1).getBrand());
        assertEquals("Almond Milk", result.get(1).getName());
    }
}