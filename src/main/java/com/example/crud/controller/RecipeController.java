package com.example.crud.controller;

import com.example.crud.dto.forCreateRecipe.RecipeRequestdto;
import com.example.crud.entity.RecipeEntity;
import com.example.crud.repository.RecipeRepository;
import com.example.crud.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/recipe")
@CrossOrigin(origins = "http://localhost:5173")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping
    public List<RecipeEntity> getAllRecipes(){ return recipeService.getAllRecipes(); };

    @GetMapping("/count")
    public int getCountOfAllRecipes(){ return recipeRepository.findAll().size(); };



    @GetMapping("/{id}")
    public RecipeEntity getRecipeById(@PathVariable String id) {
        return recipeService.getRecipeById(id)
                .orElseThrow(() -> new RuntimeException("Recipe not found with id: " + id));
    }

    @PostMapping("/create")
    public ResponseEntity<RecipeEntity> createRecipe(@RequestBody RecipeRequestdto recipeDTO) {
        RecipeEntity recipe = recipeService.createRecipe(recipeDTO);
        return ResponseEntity.ok(recipe);
    }

//    @PostMapping(value = "/create")
//    public ResponseEntity<RecipeEntity>createRecipe(@RequestBody RecipeDTO recipeRequest){
//        RecipeEntity createdRecipe = recipeService.createRecipeWithIngredients(recipeRequest);
//        return new ResponseEntity<>(createdRecipe,HttpStatus.CREATED);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable String id) {
        recipeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
