package com.example.tastytales.users.controller;

import com.example.tastytales.users.module.dao.AuthorDao;
import com.example.tastytales.users.module.entities.Author;
import jakarta.validation.Valid;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorDao authorRepository;

    // GET /author/all
    @GetMapping("/all")
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    // GET /author/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable(value = "id") Long authorId)
            throws ResourceNotFoundException {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found for this id :: " + authorId));
        return ResponseEntity.ok().body(author);
    }

    // POST /author/create
    @PostMapping("/create")
    public Author createAuthor(@Valid @RequestBody Author author) {
        return authorRepository.save(author);
    }

    // PUT /author/update/{id}
    @PutMapping("/update/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable(value = "id") Long authorId,
                                               @Valid @RequestBody Author authorDetails) throws ResourceNotFoundException {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found for this id :: " + authorId));

        author.setName(authorDetails.getName());
        author.setEmail(authorDetails.getEmail());
        author.setPassword(authorDetails.getPassword());
        final Author updatedAuthor = authorRepository.save(author);
        return ResponseEntity.ok(updatedAuthor);
    }

    // DELETE /author/delete/{id}
    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteAuthor(@PathVariable(value = "id") Long authorId)
            throws ResourceNotFoundException {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found for this id :: " + authorId));

        authorRepository.delete(author);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}