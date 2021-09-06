package com.example.recipeCatalog.repositories;

import com.example.recipeCatalog.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Query(
        value = "SELECT r.recipe_id, r.recipe_title, r.recipe_type FROM recipe r WHERE r.recipe_type = :recipeType ORDER BY RANDOM() LIMIT :count",
        nativeQuery = true
    )
    List<Recipe> findRandomRecipes(@Param("recipeType") String recipeType, @Param("count") int count);
    Recipe findByRecipeTitle(String recipeTitle);
    List<Recipe> findAllByRecipeType(String recipeType);
}
