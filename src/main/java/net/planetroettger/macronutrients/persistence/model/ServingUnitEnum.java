package net.planetroettger.macronutrients.persistence.model;

import lombok.Getter;

@Getter
public enum ServingUnitEnum {
    G("g"),
    ML("ml");

    private final String unit;

    ServingUnitEnum(String unit) {
        this.unit = unit;
    }

}