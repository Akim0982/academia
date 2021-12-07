package com.academia.controller;

import com.academia.dto.UserDto;
import com.academia.mapper.UserMapper;
import com.academia.model.User;
import com.academia.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;


    @GetMapping("{userId}")
    @PreAuthorize("hasAnyAuthority('user:read')")
    public UserDto getById(@PathVariable Long userId) {
        User user = userService.getUser(userId);
        return userMapper.toDto(user);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('user:write')")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @DeleteMapping("{userId}")
    @PreAuthorize("hasAnyAuthority('user:write')")
    public void delete(@PathVariable Long userId) {
        userService.delete(userId);
    }
}