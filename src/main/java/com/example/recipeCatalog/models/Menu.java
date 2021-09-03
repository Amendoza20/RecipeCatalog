package com.example.recipeCatalog.models;


import javax.persistence.*;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menu_id")
    Long id;
    @OneToOne(mappedBy = "recipe_id")
    Recipe mondayRecipe;
    @OneToOne(mappedBy = "recipe_id")
    Recipe tuesdayRecipe;
    @OneToOne(mappedBy = "recipe_id")
    Recipe wednesdayRecipe;
    @OneToOne(mappedBy = "recipe_id")
    Recipe thursdayRecipe;
    @OneToOne(mappedBy = "recipe_id")
    Recipe fridayRecipe;
    @OneToOne(mappedBy = "recipe_id")
    Recipe saturdayRecipe;
    @OneToOne(mappedBy = "recipe_id")
    Recipe sundayRecipe;

    public Menu(){}

    public Menu(Long id, Recipe mondayRecipe, Recipe tuesdayRecipe, Recipe wednesdayRecipe, Recipe thursdayRecipe, Recipe fridayRecipe, Recipe saturdayRecipe, Recipe sundayRecipe) {
        this.id = id;
        this.mondayRecipe = mondayRecipe;
        this.tuesdayRecipe = tuesdayRecipe;
        this.wednesdayRecipe = wednesdayRecipe;
        this.thursdayRecipe = thursdayRecipe;
        this.fridayRecipe = fridayRecipe;
        this.saturdayRecipe = saturdayRecipe;
        this.sundayRecipe = sundayRecipe;
    }

    public Long getId(){
        return id;
    }

    public Recipe getMondayRecipe() {
        return mondayRecipe;
    }

    public void setMondayRecipe(Recipe mondayRecipe) {
        this.mondayRecipe = mondayRecipe;
    }

    public Recipe getTuesdayRecipe() {
        return tuesdayRecipe;
    }

    public void setTuesdayRecipe(Recipe tuesdayRecipe) {
        this.tuesdayRecipe = tuesdayRecipe;
    }

    public Recipe getWednesdayRecipe() {
        return wednesdayRecipe;
    }

    public void setWednesdayRecipe(Recipe wednesdayRecipe) {
        this.wednesdayRecipe = wednesdayRecipe;
    }

    public Recipe getThursdayRecipe() {
        return thursdayRecipe;
    }

    public void setThursdayRecipe(Recipe thursdayRecipe) {
        this.thursdayRecipe = thursdayRecipe;
    }

    public Recipe getFridayRecipe() {
        return fridayRecipe;
    }

    public void setFridayRecipe(Recipe fridayRecipe) {
        this.fridayRecipe = fridayRecipe;
    }

    public Recipe getSaturdayRecipe() {
        return saturdayRecipe;
    }

    public void setSaturdayRecipe(Recipe saturdayRecipe) {
        this.saturdayRecipe = saturdayRecipe;
    }

    public Recipe getSundayRecipe() {
        return sundayRecipe;
    }

    public void setSundayRecipe(Recipe sundayRecipe) {
        this.sundayRecipe = sundayRecipe;
    }
}
