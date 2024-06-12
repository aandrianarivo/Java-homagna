package com.example.crud.controller;

import com.example.crud.dto.MealResponseDTO;
import com.example.crud.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("api/meal")
public class MealController {
    @Autowired
    private MealService mealService;

    @GetMapping("/toprecipes")
    public List<MealResponseDTO> getTop3Recipes() {
        return mealService.getTop3Recipes();
    }
}
