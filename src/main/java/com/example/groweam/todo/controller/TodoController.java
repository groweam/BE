package com.example.groweam.todo.controller;

import com.example.groweam.ApiResponse;
import com.example.groweam.project.domain.dto.ProjectRequestDto;
import com.example.groweam.todo.domain.dto.TodoRequestDto;
import com.example.groweam.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    // 할일 목록 조회
    @GetMapping("")

    // 할일 세부 목록 조회
    @GetMapping("/info/{todoId}")

    // 할일 등록
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createTodo(@RequestBody TodoRequestDto todoRequestDto) {
        try {
            todoService.createTodo(todoRequestDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.response(HttpStatus.BAD_REQUEST, e.getMessage()));
        }
        return ResponseEntity.ok().body(ApiResponse.response(HttpStatus.CREATED, "todo 생성 성공"));
    }

    // 할일 수정
    @PatchMapping("/{todoId}")
    public ResponseEntity<ApiResponse>


    // 할일 삭제
    @DeleteMapping("/{todoId}")
    public ResponseEntity<ApiResponse<Object>> deleteTodo(@PathVariable Long todoId) {
        try {

        } catch (Exception e) {
            return ResponseEntity.ok().body(ApiResponse.response(HttpStatus.BAD_REQUEST, e.getMessage()))
        }
        return
    }
}
