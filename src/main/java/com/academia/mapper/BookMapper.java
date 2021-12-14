package com.academia.mapper;

import com.academia.dto.BookDto;
import com.academia.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

        BookDto bookDto(Book book);
}
