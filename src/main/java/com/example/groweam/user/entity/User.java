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
    @JoinColumn(name = "project projectId", nullable = false)
    private Project projectId;

    @Column
    private String userName;

    @Column
    private String userPwd;

    @Builder
    public User(Project projectId, String userName, String userPwd) {
        this.projectId = projectId;
        this.userName = userName;
        this.userPwd = userPwd;
    }
}
