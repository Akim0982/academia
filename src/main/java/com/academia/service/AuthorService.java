package com.academia.service;

import com.academia.model.Author;
import com.academia.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public Author findById(Integer id) throws Exception {
        return authorRepository.findById(id).orElseThrow(() -> new Exception("Author not found - " + id));
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public void deleteAuthor(Integer id) {
        authorRepository.deleteById(id);
    }
}