package com.academia.controller;


import com.academia.model.Author;
import com.academia.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
    public Author getById(@PathVariable Long authorId) {
        return authorService.findById(authorId);
    }

    @PostMapping
    public Author create(@Valid @RequestBody Author author) {
        return authorService.create(author);
    }

    @Transactional
    @PutMapping("{authorId}")
    public Author update(@RequestParam Long authorId, @RequestBody Author author) {
        return authorService.update(authorId, author);
    }

    @DeleteMapping("{authorId}")
    public void delete(@PathVariable Long authorId) {
        authorService.delete(authorId);
    }
}