package com.academia.mapping;

import com.academia.model.Book;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class BookMapping {
    public Book mapping(@NotNull Book book, @NotNull Book existedBook) {
        existedBook.setTitle(book.getTitle());
        existedBook.setImageUrl(book.getImageUrl());
        return existedBook;
    }
}