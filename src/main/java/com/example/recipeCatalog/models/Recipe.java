package com.example.recipeCatalog.models;

import javax.persistence.*;


@Entity
public class Recipe {
    public enum Types{
        CHICKEN("Chicken"),
        BEEF("Beef"),
        VEGAN("Vegan");

        String label;

        private Types(String label) {
            this.label = label;
        }

        public String getLabel(){
            return label;
        }
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "recipe_id")
    private Long id;
    private String recipeTitle;
    private String recipeType;


    public Recipe(){}

    public Recipe(Long id, String recipeTitle, String recipeType){
        this.id = id;
        this.recipeTitle = recipeTitle;
        this.recipeType = recipeTitle;
    }

    public Long getId() {
        return id;
    }

    public String getRecipeTitle() {
        return recipeTitle;
    }

    public String getRecipeType() {
        return recipeType;
    }

    public void setRecipeTitle(String recipeTitle){
        this.recipeTitle = recipeTitle;
    }

    public void setRecipeType(String recipeType){
        this.recipeType = recipeType;
    }
}

