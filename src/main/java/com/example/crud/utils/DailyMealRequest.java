package com.example.crud.utils;

import com.example.crud.entity.RecipeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class DailyMealRequest {
    private String id;
    private Date mealDate;
    private String userId;
    private List<MealRequest> meals;
}
