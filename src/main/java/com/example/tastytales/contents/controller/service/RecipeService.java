package com.example.tastytales.contents.controller.service;

import com.example.tastytales.contents.module.dto.RecipeDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RecipeService {

    List<RecipeDto> getAllRecipes();

    RecipeDto getRecipeById(Long id);

    RecipeDto createRecipe(RecipeDto recipeDto);

    RecipeDto updateRecipe(Long id, RecipeDto recipeDto);

    void deleteRecipeById(Long id);

}

