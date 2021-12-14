package com.academia.controller;

import com.academia.dto.BookDto;
import com.academia.mapper.BookMapper;
import com.academia.model.Book;
import com.academia.service.BookService;
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
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping
    public BookDto getById(@PathVariable Long id) {
        Book book = bookService.findById(id);
        return bookMapper.bookDto(book);
    }

    @PostMapping
    public BookDto create(@RequestBody Book bookDto) {
        Book book = bookService.create(bookDto);
        return bookMapper.bookDto(book);
    }

    @PutMapping("{bookId}")
    public BookDto update(@RequestParam Long bookId, @Valid @RequestBody Book book1) {
        Book book = bookService.update(bookId, book1);
        return bookMapper.bookDto(book);
    }

    @DeleteMapping("{bookId}")
    public void delete(@PathVariable Long bookId) {
        bookService.delete(bookId);
    }
}