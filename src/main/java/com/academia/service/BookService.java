package com.academia.service;

import com.academia.model.Author;
import com.academia.model.Book;
import com.academia.repository.AuthorRepository;
import com.academia.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {

    public BookService() {
    }

    public BookRepository bookRepository;

    public Book findById(Integer id) throws Exception {
        return bookRepository.findById(id).orElseThrow(() -> new Exception("Book not found - " + id));
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }

}