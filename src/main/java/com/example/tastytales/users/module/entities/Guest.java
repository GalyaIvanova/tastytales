package com.example.tastytales.users.module.entities;

import com.example.tastytales.contents.module.entities.Recipe;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "guests")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private String name;

    @OneToMany(mappedBy="id", cascade=CascadeType.ALL)
    private List<Recipe> favoriteRecipes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id=id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user=user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public List<Recipe> getFavoriteRecipes() {
        return favoriteRecipes;
    }

    public void setFavoriteRecipes(List<Recipe> favoriteRecipes) {
        this.favoriteRecipes=favoriteRecipes;
    }

    public void addFavoriteRecipe(Recipe recipe) {
        this.favoriteRecipes.add(recipe);
    }

    public void removeFavoriteRecipe(Recipe recipe) {
        this.favoriteRecipes.remove(recipe);
    }

}
