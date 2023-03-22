package com.example.tastytales.contents.controller.mappers;

import com.example.tastytales.contents.module.dto.RecipeDto;
import com.example.tastytales.contents.module.entities.Recipe;
import org.springframework.stereotype.Component;

@Component
public interface RecipeMapper {
    RecipeDto toDto(Recipe recipe) ;

    Recipe toEntity(RecipeDto recipeDto) ;
}
