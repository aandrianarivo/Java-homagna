package com.example.crud.dto.fordailymeal;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class DailyMealDTOFor {
    private String id;
    private Date mealDate;
    private List<MealDTOFor> meals;
    private String userId;
}
