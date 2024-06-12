package com.example.crud.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter @Getter
public class MealPlanDTO {
    private String id;
    private String name;
    private Date dateBegin;
    private Date dateEnd;
}
