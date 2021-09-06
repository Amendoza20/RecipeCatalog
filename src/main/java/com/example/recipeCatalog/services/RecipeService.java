package com.example.recipeCatalog.services;

import com.example.recipeCatalog.models.Recipe;
import com.example.recipeCatalog.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository repository;

    public Recipe findByRecipeTitle(String recipeTitle) {
        return repository.findByRecipeTitle(recipeTitle);
    }

    public Iterable<Recipe> findAllRecipesByRecipeType(String recipeType) {
        return repository.findAllByRecipeType(recipeType);
    }

    public Iterable<Recipe> findAllRecipes(){
        return repository.findAll();
    }

    public List<String> getRecipeTypes(){
       return Arrays.stream(Recipe.Types.values())
           .map(Recipe.Types::getLabel)
           .collect(Collectors.toList());
    }

    public Recipe addRecipe(Recipe recipe) {
        Recipe duplicate = repository.findByRecipeTitle(recipe.getRecipeTitle());
        if (duplicate != null) {
            return null;
        }
        return repository.save(recipe);
    }

    public Recipe updateRecipe(Long id, Recipe recipe) {
        Recipe ogRecipe = repository.getOne(id);
        if (ogRecipe == null) {
            return null;
        }
        ogRecipe.setRecipeType(recipe.getRecipeType());
        ogRecipe.setRecipeTitle(recipe.getRecipeTitle());
        return repository.save(recipe);
    }

    public boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }

}
