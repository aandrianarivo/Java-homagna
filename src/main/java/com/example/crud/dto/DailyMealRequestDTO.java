package com.example.crud.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class DailyMealRequestDTO {
    private Date mealDate;
    private String userId;
    private String planName;
    private Date planStart;
    private Date planEnd;
    private List<String> recipes;
}
