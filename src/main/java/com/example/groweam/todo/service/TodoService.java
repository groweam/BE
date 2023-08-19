package com.example.groweam.todo.service;

import com.example.groweam.ApiResponse;
import com.example.groweam.todo.domain.dto.TodoRequestDto;
import com.example.groweam.todo.domain.dto.TodoResponseDto;
import com.example.groweam.todo.domain.entity.Todo;
import com.example.groweam.todo.repository.TodoRepository;
import com.example.groweam.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    @Transactional
    public List<TodoResponseDto> getTodo() throws Exception {
        try {
            return todoRepository.findAll().stream().map(TodoResponseDto::new)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public void createTodo(TodoRequestDto todoRequestDto) throws Exception {

        try {
                Todo todo = Todo.builder()
                        .todoTitle(todoRequestDto.getTodoTitle())
                        .todoDate(todoRequestDto.getTodoDate())
                        .todoContent(todoRequestDto.getTodoContent())
                        .isComplete(false)
                        .build();

                todoRepository.save(todo);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public void updateTodo(Long todoId, TodoRequestDto todoRequestDto) throws Exception {
        try {
            if (todoId == null) {
                throw new IllegalArgumentException("필수 데이터 누락");
            } else {
                Todo todo = todoRepository.findById(todoId)
                        .orElseThrow(() -> new IllegalArgumentException("해당 todo 존재하지 않습니다. todoId = " + todoId));

                todo.update(todoRequestDto.getTodoTitle(), todoRequestDto.getTodoDate(),
                        todoRequestDto.getTodoContent(), todoRequestDto.getIsComplete());

                todoRepository.save(todo);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public void deleteTodo(Long todoId) throws Exception {
        try {
            if (todoId == null) {
                throw new IllegalArgumentException("필수 데이터 누락");
            } else {
                Todo todo = todoRepository.findById(todoId)
                        .orElseThrow(() -> new IllegalArgumentException("해당 todo 존재하지 않습니다. todoId = " + todoId));
                todoRepository.delete(todo);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
