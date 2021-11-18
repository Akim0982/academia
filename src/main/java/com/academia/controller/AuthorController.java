package com.academia.controller;


import com.academia.model.Author;
import com.academia.service.AuthorService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> findAll() {
        return authorService.findAll();
    }

    @GetMapping("{authorId}")
    public void getById(@PathVariable Integer authorId) throws Exception {
        if (authorId == null) {
            throw new NotFoundException("Author not found ");
        }
        authorService.findById(authorId);
    }

    @PostMapping()
    public Author addNewAuthor(@RequestBody Author author) {
        authorService.save(author);
        return author;
    }

    @Transactional
    @PutMapping
    public Author updateAuthor(@RequestBody Author author) {
        authorService.save(author);
        return author;
    }

    @DeleteMapping("{authorId}")
    public void deleteAuthor(@PathVariable Integer authorId) {
        authorService.deleteAuthor(authorId);
    }
}