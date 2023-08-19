package com.example.groweam.todo.domain.dto;

import com.example.groweam.todo.domain.entity.Todo;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoResponseDto {
    private Long todoId;
    private Long userId;
    private Long projectId;
    private String todoTitle;
    private LocalDateTime todoDate;
    private String todoContent;
    private Boolean isComplete;

    public TodoResponseDto (Todo todo) {
        this.todoId = todo.getTodoId();
        this.userId = todo.getUser().getUserId();
        this.projectId = todo.getProject().getProjectId();
        this.todoTitle = todo.getTodoTitle();
        this.todoDate = todo.getTodoDate();
        this.todoContent = todo.getTodoContent();
        this.isComplete = todo.getIsComplete();
    }
}
