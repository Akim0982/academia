package com.academia.controller;


import com.academia.dto.AuthorDto;
import com.academia.mapper.AuthorMapper;
import com.academia.model.Author;
import com.academia.service.AuthorService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    @GetMapping
    public List<Author> findAll() {
        return authorService.findAll();
    }

    @GetMapping("{authorId}")
    public AuthorDto getById(@PathVariable Long authorId) {
        Author author = authorService.findById(authorId);
        return authorMapper.authorDto(author);
    }

    @PostMapping
    public AuthorDto create(@Valid @RequestBody Author authorDto) {
        Author author = authorService.create(authorDto);
        return authorMapper.authorDto(author);
    }

    @PutMapping("{authorId}")
    public AuthorDto update(@RequestParam Long authorId, @Valid @RequestBody Author authorDto) {
        Author author = authorService.update(authorId, authorDto);
        return authorMapper.authorDto(author);
    }

    @DeleteMapping("{authorId}")
    public void delete(@PathVariable Long authorId) {
        authorService.delete(authorId);
    }
}