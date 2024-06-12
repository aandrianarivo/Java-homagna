package com.example.crud.service;

import com.example.crud.dto.RecipeDTO;
import com.example.crud.dto.forCreateRecipe.Ingredientdto;
import com.example.crud.dto.forCreateRecipe.RecipeRequestdto;
import com.example.crud.entity.IngredientEntity;
import com.example.crud.entity.RecipeEntity;
import com.example.crud.entity.UserEntity;
import com.example.crud.repository.IngredientRepository;
import com.example.crud.repository.RecipeRepository;
import com.example.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private UserRepository userRepository;


    public List<RecipeEntity> getAllRecipes() {
        List<RecipeEntity> recipes = recipeRepository.findAll();
        for (RecipeEntity recipe : recipes) {
            recipe.getCreator().getId(); // Trigger lazy loading of creator
        }
        return recipes;
    }

    public Optional<RecipeEntity> getRecipeById(String id) {
        return recipeRepository.findById(id);
    }

    @Transactional
    public RecipeEntity createRecipe(RecipeRequestdto recipeDTO) {
        UserEntity user = userRepository.findById(recipeDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        RecipeEntity recipe = new RecipeEntity();
        recipe.setName(recipeDTO.getName());
        recipe.setCreator(user);

        RecipeEntity recipeToBeSaved = recipeRepository.save(recipe);

        List<IngredientEntity> ingredients = new ArrayList<>();
        for (Ingredientdto ingredientEntity : recipeDTO.getIngredients()){
            IngredientEntity ingredient = new IngredientEntity();
            ingredient.setName(ingredientEntity.getName());
            ingredient.setRecipe(recipeToBeSaved);
            ingredients.add(ingredient);
        }
        ingredientRepository.saveAll(ingredients);


        return recipeRepository.save(recipeToBeSaved);
    }

    public void deleteRecipe(String id){
        recipeRepository.deleteById(id);
    }



//    @Transactional
//    public RecipeEntity createRecipeWithIngredients(RecipeDTO newRecipe){
//        UserEntity verifyUser = userRepository.findById(newRecipe.getUser_id()).orElseThrow(()->new RuntimeException("user not found"));
//        RecipeEntity recipe = new RecipeEntity();
//        recipe.setName(newRecipe.getName());
//        recipe.setCreator(verifyUser);
//        RecipeEntity recipeToBeSaved = recipeRepository.save(recipe);
//
//        List<IngredientEntity> ingredients = new ArrayList<>();
//        for (IngredientEntity ingredientEntity : newRecipe.getIngredients()){
//            IngredientEntity ingredient = new IngredientEntity();
//            ingredient.setName(ingredientEntity.getName());
//
//
//            ingredient.setRecipe(recipeToBeSaved);
//            ingredients.add(ingredient);
//        }
//        ingredientRepository.saveAll(ingredients);
//
//        return recipeToBeSaved;
//    }
}
