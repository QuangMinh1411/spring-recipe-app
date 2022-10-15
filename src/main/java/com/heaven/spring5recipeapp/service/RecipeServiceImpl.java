package com.heaven.spring5recipeapp.service;

import com.heaven.spring5recipeapp.command.RecipeCommand;
import com.heaven.spring5recipeapp.converters.RecipeCommandToRecipe;
import com.heaven.spring5recipeapp.converters.RecipeToRecipeCommand;
import com.heaven.spring5recipeapp.domain.Recipe;
import com.heaven.spring5recipeapp.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Slf4j
@RequiredArgsConstructor
@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;




    @Override
    public Set<Recipe> getRecipes() {
        log.debug("In the service");

        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }

    @Override
    public Recipe findById(Long id) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        if(!recipeOptional.isPresent()){
            throw new RuntimeException("Recipe not found");
        }
        return recipeOptional.get();
    }

    @Override
    public RecipeCommand findCommandById(Long id) {
        return recipeToRecipeCommand.convert(findById(id));
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
        Recipe detachedRecipe = recipeCommandToRecipe.convert(command);
        Recipe saveRecipe = recipeRepository.save(detachedRecipe);
        log.debug("Save RecipeID:" + saveRecipe.getId());
        return recipeToRecipeCommand.convert(saveRecipe);
    }

    @Override
    public void deleteById(Long idToDelete) {
        recipeRepository.deleteById(idToDelete);
    }
}
