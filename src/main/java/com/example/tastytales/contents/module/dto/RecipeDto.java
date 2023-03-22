package com.example.tastytales.contents.module.dto;

import com.example.tastytales.contents.module.datatypes.enums.Category;

import java.math.BigDecimal;

public class RecipeDto {

    private Long id;
    private String title;
    private String description;
    private Category category;
    private BigDecimal rating;
    private Long likes;
    private String contentDestination;
    private Long authorId;

    public RecipeDto() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public String getContentDestination() {
        return contentDestination;
    }

    public void setContentDestination(String contentDestination) {
        this.contentDestination = contentDestination;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId=authorId;
    }
}
