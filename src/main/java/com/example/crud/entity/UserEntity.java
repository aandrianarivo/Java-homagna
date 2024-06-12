package com.example.crud.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "users")
@Setter @Getter @NoArgsConstructor @AllArgsConstructor @ToString @Builder

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String password;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "creator")
    @JsonManagedReference("creator-recipes")
    private List<RecipeEntity> recipes;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "owner")
    @JsonManagedReference("user-dailyMeals")
    private List<DailyMealEntity> dailyMeals;


}
