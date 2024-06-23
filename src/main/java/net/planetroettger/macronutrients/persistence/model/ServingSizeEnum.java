package net.planetroettger.macronutrients.persistence.model;

import lombok.Getter;

@Getter
public enum ServingSizeEnum {
    ML("ml"),
    TSP("tsp"),
    TBSP("tbsp"),
    CUP("cup"),
    G("g"),
    OUNCE("ounce");

    private final String size;

    ServingSizeEnum(String size) {
        this.size = size;
    }

}