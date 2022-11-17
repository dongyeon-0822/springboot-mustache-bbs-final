package com.mustache.springbootmustache3.service;

import com.mustache.springbootmustache3.domain.dto.UserRequest;
import com.mustache.springbootmustache3.domain.dto.UserResponse;
import com.mustache.springbootmustache3.domain.entity.User;
import com.mustache.springbootmustache3.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class UserServiceTest {
    // 그냥 DI가 아니라 Mockiti를 통한 DI를 한다.
    private UserRepository userRepository = Mockito.mock(UserRepository.class);

    private UserService userService;


    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository); // 수동으로 DI를 한다.
    }

    @Test
    @DisplayName("회원 등록 성공 message가 잘 나오는지")
    void addTest() {
        Mockito.when(userRepository.save(any()))
                .thenReturn(new User(1l,"dong","0000"));

        UserResponse userResponse = userService.addUser(new UserRequest("dong", "0000"));
        assertEquals("dong", userResponse.getUsername());
        assertEquals("user 등록이 성공했습니다.", userResponse.getMessage());
    }
}