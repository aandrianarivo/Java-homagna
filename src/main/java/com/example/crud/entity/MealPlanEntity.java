package com.example.crud.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "mealplans")
@NoArgsConstructor @AllArgsConstructor
@Setter @Getter
public class MealPlanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    private String name;
    private Date dateBegin;
    private Date dateEnd;

//    @OneToMany(mappedBy = "plan",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @JsonManagedReference("meal-dailyMeals")
//    private List<DailyMealEntity> dailyMeals;
}
