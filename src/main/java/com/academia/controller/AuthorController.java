package com.academia.controller;


import com.academia.model.Author;
import com.academia.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {

        this.authorRepository = authorRepository;
    }

    @GetMapping()
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @GetMapping("{authorId}")
    public Optional<Author> getById(@PathVariable int authorId) {
        return authorRepository.findById(authorId);

    }

    @Transactional
    @PostMapping()
    public Author addNewAuthor(@RequestBody Author author) {
        authorRepository.save(author);
        return author;
    }

    @Transactional
    @PutMapping()
    public Author updateAuthor(@RequestBody Author author) {
        authorRepository.save(author);
        return author;
    }

    @Transactional
    @DeleteMapping("{authorId}")
    public void deleteAuthor(@PathVariable Integer authorId) {
        authorRepository.deleteById(authorId);
    }
}