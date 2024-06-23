package net.planetroettger.macronutrients.persistence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(length = 255)
    private String brand;

    @Column(length = 255)
    private String name;
}