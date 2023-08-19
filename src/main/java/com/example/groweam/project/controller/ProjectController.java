package com.example.groweam.project.controller;

import com.example.groweam.ApiResponse;
import com.example.groweam.project.domain.dto.ProjectRequestDto;
import com.example.groweam.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/project")
public class ProjectController {

    public final ProjectService projectService;

    // 프로젝트 생성
    @PostMapping("")
    public ResponseEntity<ApiResponse> createProject(@RequestBody ProjectRequestDto projectRequestDto) {
        try {
            projectService.createProject(projectRequestDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.response(HttpStatus.BAD_REQUEST, e.getMessage()));
        }
        return ResponseEntity.ok().body(ApiResponse.response(HttpStatus.CREATED, "프로젝트 생성 성공"));
    }
}
