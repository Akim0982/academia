package com.academia.controller;


import com.academia.model.Book;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(path = "/test")
public class BookController {

    @GetMapping(path = "/book")
    public List<Book> getAll() {
        Book book1 = new Book();
        Book book2 = new Book();
        List<Book> book = new ArrayList<>();
        book.add(book1);
        book.add(book2);
        return book;
    }


}