package com.academia.service;

import com.academia.model.Author;
import com.academia.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorService {


    public AuthorRepository repository;

    public Author findById(Integer id) {
        return repository.findById(id).orElse(null);
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

