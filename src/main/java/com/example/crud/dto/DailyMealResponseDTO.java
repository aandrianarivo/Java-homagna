package com.example.crud.dto;

import com.example.crud.dto.fordailymeal.MealDTOFor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class DailyMealResponseDTO {
    private String id;
    private Date mealDate;
    private UserDTO owner;
    private List<MealDTOFor> meals;
}







