package com.mustache.springbootmustache3.service;

import com.mustache.springbootmustache3.domain.dto.UserRequest;
import com.mustache.springbootmustache3.domain.dto.UserResponse;
import com.mustache.springbootmustache3.domain.entity.User;
import com.mustache.springbootmustache3.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse getUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            return new UserResponse(id, "", "해당 id의 유저가 없습니다");
        } else {
            User user = optionalUser.get();
            return new UserResponse(user.getId(), user.getUsername(), "");
        }
    }

    public UserResponse addUser(UserRequest dto) {
        User user = dto.toEntity();
        // 중복 체크 기능 구현
        // 저장하기 전 username으로 select를 하여 있는지 검사를 한다.
        Optional<User> checkUser = userRepository.findUserByUsername(dto.getUsername());
        if (checkUser.isEmpty()) {
            User savedUser = userRepository.save(user);
            return new UserResponse(savedUser.getId(), savedUser.getUsername(), "user 등록이 성공했습니다.");
        } else {
            return new UserResponse(checkUser.get().getId(), dto.getUsername(), "이미 존재하는 회원입니다.");
        }
    }
}
