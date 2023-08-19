package com.example.groweam.todo.domain.dto;

import com.example.groweam.todo.domain.entity.Todo;
import com.example.groweam.user.domain.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class TodoRequestDto {

    private String todoTitle;
    private LocalDateTime todoDate;
    private String todoContent;
    private Boolean isComplete;

    @Builder
    public TodoRequestDto (Todo todo) {
        this.todoTitle = todo.getTodoTitle();
        this.todoDate = todo.getTodoDate();
        this.todoContent = todo.getTodoContent();
        this.isComplete = todo.getIsComplete();
    }

}
