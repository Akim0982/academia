package com.academia.mapper;

import com.academia.dto.AuthorDto;
import com.academia.model.Author;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDto authorDto(Author author);

}
