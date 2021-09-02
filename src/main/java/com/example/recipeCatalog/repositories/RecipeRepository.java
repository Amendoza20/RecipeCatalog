package com.example.recipeCatalog.repositories;

import com.example.recipeCatalog.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByRecipeTitle(String recipeTitle);
    List<Recipe> findByRecipeType(String recipeType);
}
