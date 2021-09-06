package com.example.recipeCatalog.wrappers;

import java.util.ArrayList;
import java.util.List;

public class RecipeTypesWrapper {
    private List<String> recipeTypes;

    public RecipeTypesWrapper() {
        this.recipeTypes = new ArrayList<>();
    }

    public RecipeTypesWrapper(List<String> recipeTypes) {
        this.recipeTypes = recipeTypes;
    }

    public List<String> getRecipeTypes() {
        return recipeTypes;
    }

    public void setRecipeTypes(List<String> recipeTypes) {
        this.recipeTypes = recipeTypes;
    }
}
