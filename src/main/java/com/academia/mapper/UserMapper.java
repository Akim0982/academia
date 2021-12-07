package com.academia.mapper;

import com.academia.dto.UserDto;
import com.academia.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserDto toDto(User user);
}
