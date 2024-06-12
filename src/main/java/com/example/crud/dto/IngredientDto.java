package com.example.crud.dto;


import com.example.crud.entity.IngredientEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class IngredientDto {
    private String id;
    private String name;

    // Getters and setters omitted for brevity

    public static IngredientDto fromIngredient(IngredientEntity ingredient) {
        IngredientDto dto = new IngredientDto();
        dto.setId(ingredient.getId());
        dto.setName(ingredient.getName());
        return dto;
    }
}
