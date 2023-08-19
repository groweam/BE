package com.example.groweam.project.service;

import com.example.groweam.project.domain.dto.ProjectRequestDto;
import com.example.groweam.project.domain.entity.Project;
import com.example.groweam.project.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public void createProject(ProjectRequestDto projectRequestDto) {
        try {
            Project project = Project.builder()
                    .projectName(projectRequestDto.getProjectName())
                    .goal(projectRequestDto.getGoal())
                    .teamName(projectRequestDto.getTeamName())
                    .projectStartDate(projectRequestDto.getProjectStartDate())
                    .projectEndDate(projectRequestDto.getProjectEndDate())
                    .build();

            projectRepository.save(project);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }
}
