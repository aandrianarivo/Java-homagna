package com.example.crud.repository;

import com.example.crud.entity.IngredientEntity;
import com.example.crud.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<IngredientEntity,String> {
}
