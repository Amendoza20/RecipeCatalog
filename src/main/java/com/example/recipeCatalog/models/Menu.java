package com.example.recipeCatalog.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menu_id")
    Long id;

    @ManyToMany
    @JoinTable(
        name = "menu_recipes",
        joinColumns = @JoinColumn(name = "menu_id"),
        inverseJoinColumns = @JoinColumn(name = "recipe_id")
    )
    List<Recipe> recipes;

    public Menu() {
    }

    public Menu(List<Recipe> recipes){
        this.recipes = recipes;
    }

    public Long getId(){
        return id;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}

