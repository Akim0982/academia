package com.academia.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class AuthorDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Set<BookDto> books;
}
