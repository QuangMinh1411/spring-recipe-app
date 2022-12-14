package com.heaven.spring5recipeapp.service;

import com.heaven.spring5recipeapp.command.RecipeCommand;
import com.heaven.spring5recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long id);
    RecipeCommand findCommandById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
    void deleteById(Long idToDelete);
}
