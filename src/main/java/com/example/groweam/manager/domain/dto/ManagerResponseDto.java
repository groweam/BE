package com.example.groweam.manager.domain.dto;

import com.example.groweam.manager.domain.entity.Manager;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ManagerResponseDto {

    private Long managerId;
    private Long todoId;
    private Long userId;
    private Long projectId;

    @Builder
    public ManagerResponseDto (Manager manager) {
        this.managerId = manager.getManagerId();
        this.todoId = manager.getTodo().getTodoId();
        this.userId = manager.getUser().getUserId();
        this.projectId = manager.getProject().getProjectId();
    }


}
