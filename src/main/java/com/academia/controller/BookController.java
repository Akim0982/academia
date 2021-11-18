package com.academia.controller;

import com.academia.model.Book;
import com.academia.service.BookService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("{bookId}")
    public void getById(@PathVariable Integer bookId) throws Exception {
        if (bookId == 0) {
            throw new NotFoundException("Book not found ");
        }
        bookService.findById(bookId);
    }

    @PostMapping()
    public Book addNewBook(@RequestBody Book book) {
        bookService.save(book);
        return book;
    }

    @Transactional
    @PutMapping
    public Book updateBook(@RequestBody Book book) {
        bookService.save(book);
        return book;
    }

    @DeleteMapping("{bookId}")
    public void deleteBook(@PathVariable Integer bookId) {
        bookService.deleteBook(bookId);
    }
}