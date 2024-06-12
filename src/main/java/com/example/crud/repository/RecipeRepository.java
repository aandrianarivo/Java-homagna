package com.example.crud.repository;

import com.example.crud.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<RecipeEntity,String> {
    RecipeEntity findByName (String name);
}
