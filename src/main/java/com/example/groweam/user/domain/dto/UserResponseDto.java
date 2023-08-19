package com.example.groweam.user.domain.dto;

import com.example.groweam.user.domain.entity.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private Long userId;
    private Long projectId;
    private String userName;
    private String userPwd;
    private String userInfo;

    public UserResponseDto (User user) {
        this.userId = user.getUserId();
        this.projectId = user.getProject().getProjectId();
        this.userName = user.getUserName();
        this.userPwd = user.getUserPwd();
        this.userInfo = user.getUserInfo();
    }

}
