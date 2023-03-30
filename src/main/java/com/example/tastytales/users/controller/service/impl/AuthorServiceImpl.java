package com.example.tastytales.users.controller.service.impl;

import com.example.tastytales.users.controller.service.AuthorService;
import com.example.tastytales.users.module.dao.AuthorDao;
import com.example.tastytales.users.module.dao.UserDao;
import com.example.tastytales.users.module.entities.Author;
import com.example.tastytales.users.module.entities.User;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorRepository;

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", String.valueOf(id)));
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author updateAuthor(Long id, Author author) {
        Author existingAuthor = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", String.valueOf(id)));
        existingAuthor.setName(author.getName());
        return authorRepository.save(existingAuthor);
    }

    @Override
    public void deleteAuthor(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", String.valueOf(id)));
        authorRepository.delete(author);
    }
}