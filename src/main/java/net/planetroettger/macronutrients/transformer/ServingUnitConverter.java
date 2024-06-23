package net.planetroettger.macronutrients.transformer;

import net.planetroettger.macronutrients.persistence.model.ServingUnitEnum;
import net.planetroettger.macronutrients.types.ServingUnit;

public class ServingUnitConverter {

    public static ServingUnitEnum toDao(ServingUnit servingUnit) {
        if (servingUnit == null) {
            return null;
        }
        return ServingUnitEnum.valueOf(servingUnit.name());
    }

    public static ServingUnit toDto(ServingUnitEnum servingUnitEnum) {
        if (servingUnitEnum == null) {
            return null;
        }
        return ServingUnit.valueOf(servingUnitEnum.name());
    }
}