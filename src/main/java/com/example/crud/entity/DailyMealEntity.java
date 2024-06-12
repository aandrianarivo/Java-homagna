package com.example.crud.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "dailyMeals")
@NoArgsConstructor @AllArgsConstructor
@Setter @Getter
public class DailyMealEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Temporal(TemporalType.DATE)
    private Date mealDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonBackReference("user-dailyMeals")
    private UserEntity owner;

    @OneToMany(mappedBy = "dailyMeal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("dailyMeal-meals")
    private List<MealEntity> meals;


}
