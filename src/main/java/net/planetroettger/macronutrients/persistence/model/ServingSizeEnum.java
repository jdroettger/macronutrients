package net.planetroettger.macronutrients.persistence.model;

public enum ServingSizeEnum {
    ML("ml"),
    TSP("tsp"),
    TBSP("tbsp"),
    CUP("cup"),
    G("g"),
    OUNCE("ounce");

    private String size;

    ServingSizeEnum(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}