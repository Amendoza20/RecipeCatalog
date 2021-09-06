package com.example.recipeCatalog.controllers;

import com.example.recipeCatalog.models.Recipe;
import com.example.recipeCatalog.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/recipe")
public class RecipeController {
    @Autowired
    private RecipeService service;

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        System.out.println("Hello");
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @GetMapping("recipe/all")
    public ResponseEntity<Iterable<Recipe>> findAllRecipesByRecipeType(@PathVariable String recipeType) {
        return new ResponseEntity<>(service.findAllRecipesByRecipeType(recipeType), HttpStatus.OK);
    }

//    @GetMapping("/recipe/{recipeTitle}")
//    public ResponseEntity<Recipe> findRecipeByTitle(@PathVariable String recipeTitle) {
//        return new ResponseEntity<>(service.findByRecipeTitle(recipeTitle), HttpStatus.OK);
//    }

    @GetMapping("/recipe/types")
    public ResponseEntity<List<String>> findAllRecipeTypes(){
        return new ResponseEntity<>(service.getRecipeTypes(), HttpStatus.OK);
    }

    @GetMapping("/recipe")
    public ResponseEntity<Iterable<Recipe>> findAllRecipe(){
        return new ResponseEntity<>(service.findAllRecipes(), HttpStatus.OK);
    }

    @PostMapping("/recipe")
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe){
        Recipe addedRecipe = service.addRecipe(recipe);
        if (addedRecipe == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(addedRecipe, HttpStatus.CREATED);
    }

    @PutMapping("/recipe/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Long id, @PathVariable Recipe recipe){
        return new ResponseEntity<>(service.updateRecipe(id, recipe), HttpStatus.OK);
    }

    @DeleteMapping("recipe/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }


}
