package com.example.recipeCatalog.repositories;

import com.example.recipeCatalog.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    Recipe findByRecipeTitle(String recipeTitle);
    List<Recipe> findAllByRecipeType(String recipeType);
}
