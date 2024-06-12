package com.example.crud.dto.fordailymeal;

import com.example.crud.dto.RecipeDTO;
import com.example.crud.dto.RecipeResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class MealDTOFor {
    private String type;
    private List<RecipeResponseDTO> recipes;
}
