package com.example.groweam.user.domain.dto;

import com.example.groweam.user.domain.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRequestDto {

    private String userName;
    private String userPwd;
    private String userInfo;

    @Builder
    public UserRequestDto(User user) {
        this.userName = user.getUserName();
        this.userPwd = user.getUserPwd();
        this.userInfo = user.getUserInfo();
    }
}
