package com.example.crud.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "meals")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MealEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String type;

    @ManyToOne
    @JoinColumn(name = "dailyMeal_id")
    @JsonBackReference("dailyMeal-meals")
    private DailyMealEntity dailyMeal;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "meal_recipe",
            joinColumns = @JoinColumn(name = "meal_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id")
    )
    @JsonManagedReference("meal-recipes")
    private List<RecipeEntity> recipes;

}