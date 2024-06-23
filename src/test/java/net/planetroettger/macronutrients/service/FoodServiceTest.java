package net.planetroettger.macronutrients.service;

import net.planetroettger.macronutrients.persistence.repository.FoodRepository;
import net.planetroettger.macronutrients.types.FoodInput;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FoodServiceTest {

    @Mock
    private FoodRepository foodRepository;

    @InjectMocks
    private FoodService foodService;

    @Test
    void validateFoodInputDuplicateFood() {
        // Given
        String duplicateName = "Name";
        String duplicateBrand = "Brand";
        when(foodRepository.existsByNameAndBrand(duplicateName, duplicateBrand)).thenReturn(true);

        FoodInput duplicateFood = createFoodInput(duplicateName, duplicateBrand);

        // When
        Exception exception = assertThrows(IllegalArgumentException.class, () -> foodService.validateFoodInput(duplicateFood));

        // Then
        String expectedMessage = "Food with name '" + duplicateName + "' and brand '" + duplicateBrand + "' already exists.";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @ParameterizedTest
    @MethodSource("provideFoodInputsForValidation")
    void validateFoodInputNameAndBrand(FoodInput foodInput, String expectedMessage) {
        // Given
        lenient().when(foodRepository.existsByNameAndBrand(foodInput.getName(), foodInput.getBrand())).thenReturn(false);

        // When
        Exception exception = assertThrows(IllegalArgumentException.class, () -> foodService.validateFoodInput(foodInput));

        // Then
        assertEquals(expectedMessage, exception.getMessage());
    }

    private static Stream<Arguments> provideFoodInputsForValidation() {
        return Stream.of(
                Arguments.of(createFoodInput("Name", "   "), "Food brand '   ' must contain more than whitespace."),
                Arguments.of(createFoodInput("   ", "Brand"), "Food name '   ' must contain more than whitespace."),
                Arguments.of(createFoodInput("   ", "   "), "Food name '   ' must contain more than whitespace."),
                Arguments.of(createFoodInput("Name", null), "Food brand 'null' must contain more than whitespace."),
                Arguments.of(createFoodInput(null, "Brand"), "Food name 'null' must contain more than whitespace.")
        );
    }

    private static FoodInput createFoodInput(String name, String brand) {
        FoodInput foodInput = new FoodInput();
        foodInput.setName(name);
        foodInput.setBrand(brand);
        return foodInput;
    }
}