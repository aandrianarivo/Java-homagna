//package com.example.crud.repository;
//
//import com.example.crud.entity.MealPlanEntity;
//import org.springframework.data.jpa.repository.EntityGraph;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import java.util.Date;
//import java.util.List;
//
//public interface MealPlanRepository extends JpaRepository<MealPlanEntity,String> {
//
//    @EntityGraph(attributePaths = "dailyMeals")
//    List<MealPlanEntity> findAll();
//    List<MealPlanEntity> findByDailyMealsIsNotNull();
//    MealPlanEntity findByDateBeginAndDateEnd(Date startDate, Date endDate);
//    MealPlanEntity findByName(String name);
//    MealPlanEntity findByDateBegin(Date datebeginDate);
//
//}
//
//
