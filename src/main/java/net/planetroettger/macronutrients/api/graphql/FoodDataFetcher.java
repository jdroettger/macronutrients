package net.planetroettger.macronutrients.api.graphql;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import net.planetroettger.macronutrients.service.FoodService;
import net.planetroettger.macronutrients.types.FoodDto;
import net.planetroettger.macronutrients.types.FoodInput;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DgsComponent
public class FoodDataFetcher {

    private final FoodService foodService;

    @Autowired
    public FoodDataFetcher(FoodService foodService) {
        this.foodService = foodService;
    }

    @DgsQuery
    public List<FoodDto> getFoods() {
        return foodService.getAllFoods();
    }

    @DgsMutation
    public FoodDto addFood(@InputArgument() FoodInput food) {
        return foodService.addFood(food);
    }
}