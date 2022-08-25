package com.heaven.spring5recipeapp.service;

import com.heaven.spring5recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
