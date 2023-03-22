package com.example.tastytales.contents.controller.mappers.impl;

import com.example.tastytales.contents.controller.mappers.RecipeMapper;
import com.example.tastytales.contents.module.dto.RecipeDto;
import com.example.tastytales.contents.module.entities.Recipe;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RecipeMapperImpl implements RecipeMapper {

    @Override
    public RecipeDto toDto(Recipe recipe) {
        RecipeDto recipeDto=new RecipeDto();
        recipeDto.setId(recipe.getId());
        //todo
        //recipeDto.setAuthor(recipe.getAuthor().getName());
        recipeDto.setTitle(recipe.getTitle());
        recipeDto.setDescription(recipe.getDescription());
        recipeDto.setCategory(recipe.getCategory());
        recipeDto.setRating(recipe.getRating());
        recipeDto.setLikes(recipe.getLikes());
        recipeDto.setContentDestination(recipe.getContentDestination());
        return recipeDto;
    }

    @Override
    public Recipe toEntity(RecipeDto recipeDto) {
        Recipe recipe=new Recipe();
        //todo
        //recipe.setAuthor(new Author(recipeDto.getAuthor()));
        recipe.setTitle(recipeDto.getTitle());
        recipe.setDescription(recipeDto.getDescription());
        recipe.setCategory(( recipeDto.getCategory() ));
        recipe.setRating(recipeDto.getRating());
        recipe.setLikes(recipeDto.getLikes());
        recipe.setContentDestination(recipeDto.getContentDestination());
        return recipe;
    }
}
