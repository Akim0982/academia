package com.academia.service;

import com.academia.model.Author;
import com.academia.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    public AuthorService() {
    }

    public AuthorRepository repository;

    public Author findById(Integer id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Author not found - " + id));
    }

    public List<Author> findAll() {
        return repository.findAll();
    }

    public Author save(Author author) {
        return repository.save(author);
    }

    public void deleteAuthor(Integer id) {
        repository.deleteById(id);
    }
}