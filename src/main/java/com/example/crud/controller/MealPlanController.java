//package com.example.crud.controller;
//
//import com.example.crud.entity.MealPlanEntity;
////import com.example.crud.service.MealPlanService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Date;
//import java.util.List;
//
//@RestController
//@RequestMapping("api/mealplan")
//public class MealPlanController {
//    @Autowired
//    private MealPlanService mealPlanService;
//
//    @GetMapping
//    public List<MealPlanEntity> getAllMealPlan (){
//        return  mealPlanService.findAllMealPlan();
//    }
//
//    @GetMapping("/{name}")
//    public MealPlanEntity getByName(@PathVariable String name){
//        return mealPlanService.findByName(name);
//    }
//    @GetMapping("/{date}")
//    public MealPlanEntity getByDate(@PathVariable Date date){
//        return mealPlanService.findByDate(date);
//    }
//
//
//}
