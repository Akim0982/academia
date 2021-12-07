package com.academia.mapping;

import com.academia.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapping {
    public Book mapping(Book book, Book existedBook) {
        existedBook.setTitle(book.getTitle());
        existedBook.setImageUrl(book.getImageUrl());
        return existedBook;
    }
}