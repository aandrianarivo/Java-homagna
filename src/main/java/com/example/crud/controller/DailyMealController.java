package com.example.crud.controller;

import com.example.crud.dto.DailyMealResponseDTO;
import com.example.crud.dto.fordailymeal.DailyMealDTOFor;
import com.example.crud.entity.DailyMealEntity;
import com.example.crud.repository.DailyMealRepository;
import com.example.crud.service.DailyMealService;
import com.example.crud.utils.DailyMealRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("api/dailymeal")
public class DailyMealController {
    @Autowired
    private DailyMealService dailyMealService;

    @Autowired
    private DailyMealRepository dailyMealRepository;

    @GetMapping(path = "/{name}")
    public List<DailyMealResponseDTO> getDailyMealsByOwnerName(@PathVariable String name) {
        List<DailyMealEntity> meals = dailyMealRepository.findByOwnerName(name);
        return dailyMealService.convertToDTOList(meals);
    }
    @GetMapping
    public List<DailyMealResponseDTO> getAllDailyMeals() {
        List<DailyMealEntity> dailyMeals = dailyMealService.getAllDailyMeals();
        return dailyMealService.convertToDTOList(dailyMeals);
    }

    @GetMapping(path = "/{date}/date")
    public DailyMealEntity getByDate(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return dailyMealService.getMealsByDate(date);
    }



    @PostMapping("/create")
    public ResponseEntity<DailyMealResponseDTO> createDailyMeal(@RequestBody DailyMealDTOFor request) {
        DailyMealEntity savedDailyMeal = dailyMealService.createDailyMealWithPlan(request);
        return ResponseEntity.ok(dailyMealService.convertToDTO(savedDailyMeal));
    }
}
