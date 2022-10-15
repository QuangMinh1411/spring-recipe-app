package com.heaven.spring5recipeapp.controller;

import com.heaven.spring5recipeapp.command.RecipeCommand;
import com.heaven.spring5recipeapp.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/show/{id}")
    public String showById(@PathVariable Long id, Model model){
        model.addAttribute("recipe",recipeService.findById(id));
        return "recipe/show";
    }
    @GetMapping("/new")
    public String newRecipe(Model model){
        model.addAttribute("recipe",new RecipeCommand());
        return "/recipe/recipeform";
    }
    @GetMapping("/{id}/update")
    public String updateRecipe(@PathVariable Long id, Model model){
        model.addAttribute("recipe",recipeService.findCommandById(id));
        return "/recipe/recipeform";
    }

    @PostMapping
    public String saveOrUpdate(@ModelAttribute RecipeCommand recipeCommand){
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(recipeCommand);
        return "redirect:/recipe/show/" + savedCommand.getId();
    }

    @GetMapping("/{id}/delete")
    public String deleteById(@PathVariable Long id){
        recipeService.deleteById(id);
        return "redirect:/";
    }
}
