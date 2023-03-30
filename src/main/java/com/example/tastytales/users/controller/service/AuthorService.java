package com.example.tastytales.users.controller.service;

import com.example.tastytales.users.module.entities.Author;
import org.springframework.stereotype.Component;

@Component
public interface AuthorService {

    Author getAuthorById(Long id);

    Author createAuthor(Author author);

    Author updateAuthor(Long id, Author author);

    void deleteAuthor(Long id);
}
