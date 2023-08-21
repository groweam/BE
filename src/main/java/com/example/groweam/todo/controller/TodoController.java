package com.example.groweam.todo.controller;

import com.example.groweam.ApiResponse;
import com.example.groweam.todo.domain.dto.TodoRequestDto;
import com.example.groweam.todo.domain.dto.TodoResponseDto;
import com.example.groweam.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    // 할일 목록 조회
    @GetMapping("")
    public ResponseEntity<ApiResponse<List<TodoResponseDto>>> getTodo() {
        try {
            List<TodoResponseDto> todoResponseDto = todoService.getTodo();
            return ResponseEntity.ok().body(ApiResponse.response(HttpStatus.OK, "todo 조회 성공", todoResponseDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.response(HttpStatus.BAD_REQUEST, e.getMessage()));
        }
    }

    // 할일 등록
    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Object>> createTodo(@RequestBody TodoRequestDto todoRequestDto) {
        todoService.createTodo(todoRequestDto);
        return ResponseEntity.ok().body(ApiResponse.response(HttpStatus.CREATED, "todo 생성 성공"));
//        try {
//            todoService.createTodo(todoRequestDto);
//            return ResponseEntity.ok().body(ApiResponse.response(HttpStatus.CREATED, "todo 생성 성공"));
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(ApiResponse.response(HttpStatus.BAD_REQUEST, e.getMessage()));
//        }
    }

    // 할일 수정
    @PatchMapping("/{todoId}")
    public ResponseEntity<ApiResponse<Object>> updateTodo(@PathVariable Long todoId, @RequestBody TodoRequestDto todoRequestDto) {
        try {
            todoService.updateTodo(todoId, todoRequestDto);
            return ResponseEntity.ok().body(ApiResponse.response(HttpStatus.OK, "todo 수정 성공"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.response(HttpStatus.BAD_REQUEST, e.getMessage()));
        }
    }


    // 할일 삭제
    @DeleteMapping("/{todoId}")
    public ResponseEntity<ApiResponse<Object>> deleteTodo(@PathVariable Long todoId) {
        try {
            todoService.deleteTodo(todoId);
            return ResponseEntity.ok().body(ApiResponse.response(HttpStatus.OK, "todo 삭제 성공"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.response(HttpStatus.BAD_REQUEST, e.getMessage()));
        }
    }

}
