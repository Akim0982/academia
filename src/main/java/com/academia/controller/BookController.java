package com.academia.controller;

import com.academia.model.Book;
import com.academia.service.BookService;
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

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("{bookId}")
    public Book getById(@PathVariable Long bookId) {
        return bookService.findById(bookId);
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        bookService.save(book);
        return book;
    }

    @Transactional
    @PutMapping
    public Book update(@RequestParam Long bookId, @RequestBody Book book) {
        return bookService.update(bookId, book);
    }

    @DeleteMapping("{bookId}")
    public void delete(@PathVariable Long bookId) {
        bookService.delete(bookId);
    }
}