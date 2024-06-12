package com.example.crud.repository;

import com.example.crud.entity.DailyMealEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface DailyMealRepository extends JpaRepository<DailyMealEntity,String> {
  DailyMealEntity findByMealDate(LocalDate date);
  List<DailyMealEntity> findByOwnerName(String name);}
