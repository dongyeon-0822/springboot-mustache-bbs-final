package com.mustache.springbootmustache3.controller;

import com.mustache.springbootmustache3.domain.dto.UserRequest;
import com.mustache.springbootmustache3.domain.dto.UserResponse;
import com.mustache.springbootmustache3.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {
    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.getUserId(id));
    }

}
