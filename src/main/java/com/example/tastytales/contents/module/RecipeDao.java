package com.example.tastytales.contents.module;

import com.example.tastytales.contents.module.entities.Recipe;
import com.example.tastytales.users.module.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeDao extends JpaRepository<Recipe, Long> {

}
