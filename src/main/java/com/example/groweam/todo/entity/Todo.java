package com.example.groweam.todo.entity;

import com.example.groweam.project.entity.Project;
import com.example.groweam.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "Todo")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long todoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project projectId", nullable = false)
    private Project projectId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user userId", nullable = false)
    private User userId;

    @Column
    private String todoTitle;

    @Column
    private String manager;

    @Column
    private LocalDateTime todoDate;

    @Column
    private String todoContent;

    @Column
    private Boolean isComplete;

    @Builder
    public Todo (Project projectId, User userId, String todoTitle, String manager, LocalDateTime todoDate, String todoContent, Boolean isComplete) {
        this.projectId = projectId;
        this.userId = userId;
        this.todoTitle = todoTitle;
        this.manager = manager;
        this.todoDate = todoDate;
        this.todoContent = todoContent;
        this.isComplete = isComplete;
    }

}
