package com.example.crud.dto;

import com.example.crud.entity.IngredientEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class RecipeDTO {
    private String name;
    private List<IngredientEntity> ingredients;
    private String user_id;
}
