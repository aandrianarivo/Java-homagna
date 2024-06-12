package com.example.crud.service;

import com.example.crud.dto.MealResponseDTO;
import com.example.crud.entity.RecipeEntity;
import com.example.crud.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MealService {
    @Autowired
    private MealRepository mealRepository;

    public List<MealResponseDTO> getTop3Recipes() {
        List<Object[]> topRecipes = mealRepository.findTop3Recipes();
        return topRecipes.stream()
                .map(result -> new MealResponseDTO(((RecipeEntity) result[0]).getName()))
                .collect(Collectors.toList());
    }
}
