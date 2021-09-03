package com.example.recipeCatalog.controllers;

import com.example.recipeCatalog.models.Recipe;
import com.example.recipeCatalog.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RecipeController {
    @Autowired
    private RecipeService service;

    @RequestMapping("recipe/all")
    public ResponseEntity<Iterable<Recipe>> findAllRecipesByRecipeType(@PathVariable String recipeType) {
        return new ResponseEntity<>(service.findAllRecipesByRecipeType(recipeType), HttpStatus.OK);
    }

    @GetMapping("/recipe/{recipeTitle}")
    public ResponseEntity<Recipe> findRecipeByTitle(@PathVariable String recipeTitle) {
        return new ResponseEntity<>(service.findByRecipeTitle(recipeTitle), HttpStatus.OK);
    }

    @PostMapping("/recipe")
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe){
        return new ResponseEntity<>(service.addRecipe(recipe), HttpStatus.OK);
    }


}
