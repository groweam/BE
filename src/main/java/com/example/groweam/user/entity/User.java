package com.example.groweam.user.entity;

import com.example.groweam.project.entity.Project;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "User")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projectId", nullable = false)
    private Project project;

    @Column
    private String userName;

    @Column
    private String userPwd;

    @Column
    private String userInfo;

    @Builder
    public User(Project project, String userName, String userPwd, String userInfo) {
        this.project = project;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userInfo = userInfo;
    }
}
