package com.example.crud.dto.forCreateRecipe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeRequestdto {
    private String name;
    private List<Ingredientdto> ingredients;
    private String userId;
}
