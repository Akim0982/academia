package com.academia.service;

import com.academia.exception.ResourceNotFoundException;
import com.academia.mapping.AuthorMapping;
import com.academia.model.Author;
import com.academia.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapping authorMapping;

    public AuthorService(AuthorRepository authorRepository, AuthorMapping authorMapping) {
        this.authorRepository = authorRepository;
        this.authorMapping = authorMapping;
    }

    @Transactional(readOnly = true)
    public Author findById(Long id) {
        return authorRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found - " + id));
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Transactional
    public Author create(Author author) {
        return authorRepository.save(author);
    }

    @Transactional
    public Author update(Long id, Author author) {
        Author existedAuthor = findById(id);
        return authorRepository.save(authorMapping.mapping(author, existedAuthor));
    }

    @Transactional
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
}