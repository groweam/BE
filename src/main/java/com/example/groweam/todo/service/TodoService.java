package com.example.groweam.todo.service;

import com.example.groweam.project.domain.entity.Project;
import com.example.groweam.todo.domain.dto.TodoRequestDto;
import com.example.groweam.todo.domain.entity.Todo;
import com.example.groweam.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public void createTodo(TodoRequestDto todoRequestDto) {
//        try {
//
//        } catch (Exception e) {
//            log.info(e.getMessage());
//        }
    }


    public void deleteTodo(Long todoId) {
        todoRepository.deleteById(todoId);
    }
}
