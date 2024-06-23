package net.planetroettger.macronutrients.persistence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "food")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodDao {

    @Id
    @GeneratedValue
    private UUID id;

    private String brand;
    private String name;
    private BigDecimal protein;
    private BigDecimal fat;
    private BigDecimal carb;
    private BigDecimal fiber;
    private BigDecimal calories;
    private BigDecimal servingAmount;

    @Enumerated(EnumType.STRING)
    private ServingUnitEnum servingUnit;

    @Enumerated(EnumType.STRING)
    private ServingSizeEnum servingSize;
}