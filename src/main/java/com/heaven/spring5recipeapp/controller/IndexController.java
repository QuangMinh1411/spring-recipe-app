package com.heaven.spring5recipeapp.controller;

import com.heaven.spring5recipeapp.domain.Category;
import com.heaven.spring5recipeapp.domain.UnitOfMeasure;
import com.heaven.spring5recipeapp.repository.CategoryRepository;
import com.heaven.spring5recipeapp.repository.UnitOfMeasureRepository;
import com.heaven.spring5recipeapp.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;
@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping({"","/","/index"})
    public String getIndexPage(Model model){
        log.debug("Loading recipes");
        model.addAttribute("recipes",recipeService.getRecipes());
        return "index";
    }


}
