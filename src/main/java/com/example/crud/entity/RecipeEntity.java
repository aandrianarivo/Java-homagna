package com.example.crud.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "recipes")
@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
@ToString @Builder
public class RecipeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    @OneToMany(mappedBy = "recipe")
    @JsonManagedReference("recipe-ingredients")
    private List<IngredientEntity> ingredients;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "creator_user")
    @JsonBackReference("creator-recipes")
    private UserEntity creator;


    @ManyToMany(mappedBy = "recipes", fetch = FetchType.LAZY)
    @JsonBackReference("meal-recipes")
    private List<MealEntity> meals;
}
