package net.planetroettger.macronutrients.service;

import net.planetroettger.macronutrients.persistence.repository.FoodRepository;
import net.planetroettger.macronutrients.types.FoodDto;
import net.planetroettger.macronutrients.types.FoodInput;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
class FoodServiceTest {

    @Autowired
    private FoodService foodService;

    @Autowired
    private FoodRepository foodRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {
        foodRepository.deleteAll();
    }

    @Test
    void addFood() {
        FoodInput foodInput = new FoodInput();
        foodInput.setBrand("Trader Joe's");
        foodInput.setName("Peanut Butter");

        FoodDto result = foodService.addFood(foodInput);

        assertEquals("Trader Joe's", result.getBrand());
        assertEquals("Peanut Butter", result.getName());

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