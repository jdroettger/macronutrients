package net.planetroettger.macronutrients.transformer;

import net.planetroettger.macronutrients.persistence.model.ServingSizeEnum;
import net.planetroettger.macronutrients.types.ServingSize;

public class ServingSizeConverter {

    public static ServingSizeEnum toDao(ServingSize servingSize) {
        if (servingSize == null) {
            return null;
        }
        return ServingSizeEnum.valueOf(servingSize.name());
    }

    public static ServingSize toDto(ServingSizeEnum servingSizeEnum) {
        if (servingSizeEnum == null) {
            return null;
        }
        return ServingSize.valueOf(servingSizeEnum.name());
    }
}