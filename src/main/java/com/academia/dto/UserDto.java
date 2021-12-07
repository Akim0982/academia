package com.academia.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class UserDto {
    private Long id;
    private String email;
    private Set<RoleDto> roles;
}
