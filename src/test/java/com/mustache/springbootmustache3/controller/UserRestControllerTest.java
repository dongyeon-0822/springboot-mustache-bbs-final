package com.mustache.springbootmustache3.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mustache.springbootmustache3.domain.dto.ArticleAddRequest;
import com.mustache.springbootmustache3.domain.dto.ArticleAddResponse;
import com.mustache.springbootmustache3.domain.dto.UserRequest;
import com.mustache.springbootmustache3.domain.dto.UserResponse;
import com.mustache.springbootmustache3.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserRestController.class)
class UserRestControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("입력한 id로 조회가 잘 되는지")
    void findUserById() throws Exception {
        given(userService.getUser(1l)).willReturn(new UserResponse(1l,"dong","user 등록이 성공했습니다."));

        mockMvc.perform(get("/api/v1/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.id").value(1))
                .andDo(print());
    }

    @Test
    @DisplayName("입력한 Id로 조회 실패 했을 때 message 잘 나오는지")
    void findByIdFail() throws Exception {
        given(userService.getUser(3l)).willReturn(new UserResponse(null, "", "해당 id의 유저가 없습니다"));
        mockMvc.perform(get("/api/v1/users/3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isEmpty())
                .andExpect(jsonPath("$.message").value("해당 id의 유저가 없습니다"))
                .andDo(print());
    }

    @Test
    @DisplayName("User 등록이 잘 되는지")
    void addUser() throws Exception {
        UserRequest dto = new UserRequest("동연", "비밀");

        given(userService.addUser(dto)).willReturn(new UserResponse(3l,"동연", "비밀"));

        mockMvc.perform(post("/api/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(new UserRequest("동연", "비밀")))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.username").exists())
                .andDo(print());
    }
}