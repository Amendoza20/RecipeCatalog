package com.example.recipeCatalog.models;

import javax.persistence.*;


@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "recipe_id")
    private Long id;
    private String title;
    private String mealType;

    public Recipe(){}

    public Recipe(Long id, String title, String mealType){
        this.id = id;
        this.title = title;
        this.mealType = mealType;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMealType() {
        return mealType;
    }

    public void setTitle (String title){
        this.title = title;
    }

    public void setMealType (String mealType){
        this.mealType = mealType;
    }
}

