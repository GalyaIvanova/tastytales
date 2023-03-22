package com.example.tastytales.contents.module.entities;

import com.example.tastytales.contents.module.datatypes.enums.Category;
import com.example.tastytales.users.module.entities.Author;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;

import java.math.BigDecimal;

@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="author_id")
    private Author author;

    @Column(nullable = false)
    private String title;

    private String description;

    private Category category;

    @Digits(fraction=1,integer=2)
    private BigDecimal rating;

    private Long likes;

    private String contentDestination;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id=id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author=author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title=title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description=description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category=category;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating=rating;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes=likes;
    }

    public String getContentDestination() {
        return contentDestination;
    }

    public void setContentDestination(String contentDestination) {
        this.contentDestination=contentDestination;
    }
}
