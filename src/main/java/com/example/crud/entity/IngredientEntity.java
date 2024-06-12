package com.example.crud.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ingredients")
@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
@ToString @Builder
public class IngredientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    @ManyToOne()
    @JoinColumn(name = "recipe_id")
    @JsonBackReference("recipe-ingredients")
    private RecipeEntity recipe;
}
