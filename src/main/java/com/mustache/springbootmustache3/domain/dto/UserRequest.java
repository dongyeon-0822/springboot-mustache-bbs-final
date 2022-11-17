package com.mustache.springbootmustache3.domain.dto;

import com.mustache.springbootmustache3.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    // 요청에서는 id를 전달할 필요가 없다.
    private String username;
    private String password;

    public User toEntity() { // user entity로 변환
        User user = User.builder()
                .username(this.username)
                .password(this.password)
                .build();
        return user;
    }
}
