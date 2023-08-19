package com.example.groweam.todo.domain.entity;

import com.example.groweam.project.domain.entity.Project;
import com.example.groweam.user.domain.entity.User;
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
    @JoinColumn(name = "projectId", nullable = false)
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

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
    public Todo (Project project, User user, String todoTitle, String manager, LocalDateTime todoDate, String todoContent, Boolean isComplete) {
        this.project = project;
        this.user = user;
        this.todoTitle = todoTitle;
        this.manager = manager;
        this.todoDate = todoDate;
        this.todoContent = todoContent;
        this.isComplete = isComplete;
    }

}
