package com.example.tastytales.contents.module;

import com.example.tastytales.contents.module.entities.Recipe;
import com.example.tastytales.users.module.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeDao extends JpaRepository<Recipe, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Recipe r SET r.likes = r.likes + 1 WHERE r.id = :recipeId")
    void increaseLikes(@Param("recipeId") Long recipeId);

    @Transactional
    @Modifying
    @Query("UPDATE Recipe r SET r.likes = r.likes - 1 WHERE r.id = :recipeId")
    void decreaseLikes(@Param("recipeId") Long recipeId);

}
