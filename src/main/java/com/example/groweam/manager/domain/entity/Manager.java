package com.example.groweam.manager.domain.entity;

import com.example.groweam.project.domain.entity.Project;
import com.example.groweam.todo.domain.entity.Todo;
import com.example.groweam.user.domain.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Manger")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long managerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todoId", nullable = false)
    private Todo todo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projectId", nullable = false)
    private Project project;

    @Builder
    public Manager (Todo todo, User user, Project project) {
        this.todo = todo;
        this.user = user;
        this.project = project;
    }

}
