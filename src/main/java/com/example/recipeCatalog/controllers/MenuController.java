package com.example.recipeCatalog.controllers;

import com.example.recipeCatalog.models.Menu;
import com.example.recipeCatalog.models.Recipe;
import com.example.recipeCatalog.services.MenuService;
import com.example.recipeCatalog.services.RecipeService;
import com.example.recipeCatalog.wrappers.RecipeTypesWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MenuController {

    @Autowired
    private MenuService service;

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/menu")
    public ResponseEntity<Menu> findById(@PathVariable Long id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("/menu")
    public ResponseEntity<Menu> createMenuFromRecipe(List<Recipe> recipes){
        return new ResponseEntity<>(service.createMenuFromRecipes(recipes), HttpStatus.CREATED);
    }

    @PostMapping("/menu/recipetypes")
    public ResponseEntity<Menu> createMenuFromRecipeTypes(@RequestBody RecipeTypesWrapper wrapper) {
        List<Recipe> recipes = recipeService.findRandomRecipes(wrapper.getRecipeTypes());
        return new ResponseEntity<>(service.createMenuFromRecipes(recipes), HttpStatus.CREATED);
    }

    @PutMapping("/menu/{id}")
    public ResponseEntity<Menu> update(@PathVariable Long id, Menu menu){
        return new ResponseEntity<>(service.update(id, menu), HttpStatus.OK);
    }

    @DeleteMapping("/menu/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

}
