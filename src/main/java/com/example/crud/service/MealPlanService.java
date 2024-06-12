//package com.example.crud.service;
//
//import com.example.crud.entity.MealPlanEntity;
////import com.example.crud.repository.MealPlanRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//import java.util.List;
//
//@Service
//public class MealPlanService {
//    @Autowired
//    private MealPlanRepository mealPlanRepository;
//
//    public List<MealPlanEntity> findAllMealPlan(){
//        return mealPlanRepository.findByDailyMealsIsNotNull();
//    }
//
//    public MealPlanEntity findByDate(Date date){
//        return mealPlanRepository.findByDateBegin(date);
//    }
//    public MealPlanEntity findByName(String name){
//        return mealPlanRepository.findByName(name);
//    }
//}
