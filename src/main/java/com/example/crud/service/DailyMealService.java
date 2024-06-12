package com.example.crud.service;

import com.example.crud.dto.*;
import com.example.crud.dto.fordailymeal.DailyMealDTOFor;
import com.example.crud.dto.fordailymeal.MealDTOFor;
import com.example.crud.entity.*;
import com.example.crud.repository.DailyMealRepository;
//import com.example.crud.repository.MealPlanRepository;
import com.example.crud.repository.RecipeRepository;
import com.example.crud.repository.UserRepository;
import com.example.crud.utils.DailyMealRequest;
import com.example.crud.utils.MealRequest;
import com.example.crud.utils.RecipeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class DailyMealService {
    @Autowired
    private DailyMealRepository dailyMealRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    public List<DailyMealEntity> getAllDailyMeals() {
        return dailyMealRepository.findAll();
    }

    public DailyMealEntity getMealsByDate(LocalDate mealDate) {
        return dailyMealRepository.findByMealDate(mealDate);
    }

    @Transactional
    public DailyMealEntity createDailyMealWithPlan(DailyMealDTOFor request) {
        // Crée une nouvelle instance de DailyMealEntity
        DailyMealEntity dailyMeal = new DailyMealEntity();
        dailyMeal.setMealDate(request.getMealDate());

        // Recherche l'utilisateur par userId
        UserEntity user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Associe l'utilisateur à DailyMealEntity
        dailyMeal.setOwner(user);

        // Liste pour stocker les MealEntity associées
        List<MealEntity> meals = new ArrayList<>();

        // Parcourt chaque MealRequest dans la requête
        for (MealDTOFor mealRequest : request.getMeals()) {
            // Crée une nouvelle instance de MealEntity
            MealEntity meal = new MealEntity();
            meal.setType(mealRequest.getType());

            // Liste pour stocker les RecipeEntity associées
            List<RecipeEntity> recipes = new ArrayList<>();
            for (RecipeResponseDTO recipeRequest : mealRequest.getRecipes()) {
                // Recherche la RecipeEntity par son nom
                RecipeEntity recipe = recipeRepository.findByName(recipeRequest.getName());
                if (recipe != null) {
                    // Ajoute la recette trouvée à la liste des recettes du repas
                    recipes.add(recipe);
                }
            }
            // Associe les recettes au repas
            meal.setRecipes(recipes);
            // Associe le repas à DailyMealEntity
            meal.setDailyMeal(dailyMeal);
            // Ajoute le repas à la liste des repas
            meals.add(meal);
        }
        // Associe les repas à DailyMealEntity
        dailyMeal.setMeals(meals);

        // Sauvegarde DailyMealEntity dans le repository et retourne l'entité sauvegardée
        return dailyMealRepository.save(dailyMeal);
    }

    public DailyMealResponseDTO convertToDTO(DailyMealEntity entity) {
        DailyMealResponseDTO dto = new DailyMealResponseDTO();
        dto.setId(entity.getId());
        dto.setMealDate(entity.getMealDate());

        UserDTO userDTO = new UserDTO();
        userDTO.setId(entity.getOwner().getId());
        userDTO.setName(entity.getOwner().getName());
        dto.setOwner(userDTO);

        List<MealDTOFor> mealDTOs = new ArrayList<>();
        for (MealEntity meal : entity.getMeals()) {
            MealDTOFor mealDTO = new MealDTOFor();
            mealDTO.setType(meal.getType());

            List<RecipeResponseDTO> recipeDTOs = new ArrayList<>();
            for (RecipeEntity recipe : meal.getRecipes()) {
                RecipeResponseDTO recipeDTO = new RecipeResponseDTO();
                recipeDTO.setId(recipe.getId());
                recipeDTO.setName(recipe.getName());
                recipeDTOs.add(recipeDTO);
            }
            mealDTO.setRecipes(recipeDTOs);
            mealDTOs.add(mealDTO);
        }
        dto.setMeals(mealDTOs);

        return dto;
    }
    public List<DailyMealResponseDTO> convertToDTOList(List<DailyMealEntity> entities) {
        //List<DailyMealResponseDTO> dtos = new ArrayList<>();
        //for (DailyMealEntity entity : entities) {
        //    dtos.add(convertToDTO(entity));
        //}
        return entities.stream().map(this::convertToDTO).collect(Collectors.toList());
        //return dtos;
    }

}
