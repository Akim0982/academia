package com.academia.mapping;

import com.academia.model.Author;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapping {
    public Author mapping(@NotNull Author author, @NotNull Author existedAuthor) {
        existedAuthor.setFirstName(author.getFirstName());
        existedAuthor.setLastName(author.getLastName());
        return existedAuthor;
    }
}