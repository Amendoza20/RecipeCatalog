package com.example.recipeCatalog.services;

import com.example.recipeCatalog.models.Recipe;
import com.example.recipeCatalog.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository repository;

    public Recipe findByRecipeTitle(String recipeTitle){
        return repository.findByRecipeTitle(recipeTitle);
    }

    public Iterable<Recipe> findAllRecipesByRecipeType(String recipeType){
        return repository.findAllByRecipeType(recipeType);
    }

    public Recipe addRecipe(Recipe recipe){
        return repository.save(recipe);
    }

    public Recipe updateRecipe(Long id, Recipe recipe){
        Recipe ogRecipe = repository.getOne(id);
        if (ogRecipe == null){
            return null;
        }
        ogRecipe.setRecipeType(recipe.getRecipeType());
        ogRecipe.setRecipeTitle(recipe.getRecipeTitle());
        return repository.save(recipe);
    }

    public boolean delete(Long id){
        repository.deleteById(id);
        return true;
    }

}
