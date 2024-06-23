package net.planetroettger.macronutrients.persistence.model;

public enum ServingUnitEnum {
    G("g"),
    ML("ml");

    private String unit;

    ServingUnitEnum(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }
}