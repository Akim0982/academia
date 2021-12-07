package com.academia.mapping;

import com.academia.model.Author;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
@NotNull
public class AuthorMapping {
    public Author mapping(Author author, Author existedAuthor) {
        existedAuthor.setFirstName(author.getFirstName());
        existedAuthor.setLastName(author.getLastName());
        return existedAuthor;
    }
}