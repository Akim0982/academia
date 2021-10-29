package com.academia.controller;


import com.academia.model.Author;
import com.academia.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/test/authors")
public class AuthorController {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {

        this.authorRepository = authorRepository;
    }

    @GetMapping("")
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @GetMapping("{authorId}")
    public Optional<Author> getById(@PathVariable int authorId) {
        return authorRepository.findById(authorId);

    }

    @PostMapping()
    public Author addNewAuthor(@RequestBody Author author) {
        authorRepository.save(author);
        return author;
    }

    @PutMapping()
    public Author updateAuthor(@RequestBody Author theAuthor) {
        authorRepository.save(theAuthor);
        return theAuthor;
    }

    @DeleteMapping("{authorId}")
    public String deleteAuthor(@PathVariable Integer authorId) {
        authorRepository.deleteById(authorId);
        return "Delete Author Id - " + authorId;
    }
}