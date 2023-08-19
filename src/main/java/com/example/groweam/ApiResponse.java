package com.example.groweam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ApiResponse<T> {

    private int status;
    private String message;
    private T data;

    public ApiResponse(int status, String message) {
        this.status = status;
        this.message = message;
        this.data = null;
    }

    public static<T> ApiResponse<T> response(int status, String message) {
        return response(status, message, null);
    }

    public static<T> ApiResponse<T> response(int status, String message, T t) {
        return ApiResponse.<T>builder()
                .status(status)
                .message(message)
                .data(t)
                .build();
    }
}
