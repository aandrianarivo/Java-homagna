package com.example.crud.repository;

import com.example.crud.entity.MealEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<MealEntity,String> {
    @Query("SELECT r, COUNT(m) AS count FROM MealEntity m JOIN m.recipes r GROUP BY r ORDER BY count DESC")
    List<Object[]> findTop3Recipes();

}
