package com.example.tastytales.contents.controller.service.impl;

import com.example.tastytales.contents.controller.mappers.RecipeMapper;
import com.example.tastytales.contents.controller.service.RecipeService;
import com.example.tastytales.contents.module.RecipeDao;
import com.example.tastytales.contents.module.dto.RecipeDto;
import com.example.tastytales.contents.module.entities.Recipe;
import com.example.tastytales.utils.exceptions.RecipeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService {
    @Autowired
    private RecipeDao recipeDao;
    @Autowired
    private RecipeMapper recipeMapper;

    @Override
    public RecipeDto createRecipe(RecipeDto recipeDto) {
        Recipe recipe=recipeMapper.toEntity(recipeDto);
        Recipe savedRecipe=recipeDao.save(recipe);
        return recipeMapper.toDto(savedRecipe);
    }

    @Override
    public RecipeDto getRecipeById(Long id) {
        Optional<Recipe> recipe=recipeDao.findById(id);
        if (recipe.isPresent()) {
            return recipeMapper.toDto(recipe.get());
        }
        throw new RecipeNotFoundException(id);
    }

    @Override
    public List<RecipeDto> getAllRecipes() {
        List<Recipe> recipes=recipeDao.findAll();
        return recipes.stream()
                .map(recipeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RecipeDto updateRecipe(Long id, RecipeDto recipeDto) {
        Optional<Recipe> optionalRecipe=recipeDao.findById(id);
        if (optionalRecipe.isPresent()) {
            Recipe recipeToUpdate=optionalRecipe.get();
            recipeToUpdate.setTitle(recipeDto.getTitle());
            recipeToUpdate.setDescription(recipeDto.getDescription());
            recipeToUpdate.setCategory(recipeDto.getCategory());
            recipeToUpdate.setRating(recipeDto.getRating());
            recipeToUpdate.setLikes(recipeDto.getLikes());
            recipeToUpdate.setContentDestination(recipeDto.getContentDestination());
            Recipe updatedRecipe=recipeDao.save(recipeToUpdate);
            return recipeMapper.toDto(updatedRecipe);
        }
        throw new RecipeNotFoundException(id);
    }

    @Override
    public void deleteRecipeById(Long id) {
        recipeDao.deleteById(id);
    }


}

