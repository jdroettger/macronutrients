package net.planetroettger.macronutrients.persistence.repository;

import net.planetroettger.macronutrients.persistence.model.FoodDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FoodRepository extends JpaRepository<FoodDao, UUID> {
    boolean existsByNameAndBrand(String name, String brand);
}