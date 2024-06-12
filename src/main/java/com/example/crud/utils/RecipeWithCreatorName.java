package com.example.crud.utils;

import com.example.crud.entity.RecipeEntity;

import java.util.ArrayList;

public class RecipeWithCreatorName extends ArrayList<RecipeEntity> {

    @Override
    public RecipeEntity get(int index) {
        RecipeEntity recipe = super.get(index);
//        recipe.getCreator().fetch(); // Explicitly fetch the creator user
        return recipe;
    }
}
