package com.academia.service;

import com.academia.exception.ResourceNotFoundException;
import com.academia.mapping.BookMapping;
import com.academia.model.Book;
import com.academia.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class BookService {

    public final BookRepository bookRepository;
    public final AuthorService authorService;
    public final BookMapping bookMapping;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorService authorService, BookMapping bookMapping) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.bookMapping = bookMapping;
    }

    @Transactional(readOnly = true)
    public Book findById(Long id) {
        return bookRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found - " + id));
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Transactional
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    public Book update(Long id, Book book) {
        Book existedBook = findById(id);
        return bookRepository.save(bookMapping.mapping(book, existedBook));
    }

    @Transactional
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}