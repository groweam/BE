package com.example.groweam.project.domain.dto;

import com.example.groweam.project.domain.entity.Project;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ProjectRequestDto {

    String projectName;
    String goal;
    String teamName;
    LocalDateTime projectStartDate;
    LocalDateTime projectEndDate;

    @Builder
    public ProjectRequestDto(Project project) {
        this.projectName = project.getProjectName();
        this.goal = project.getGoal();
        this.teamName = project.getTeamName();
        this.projectStartDate = project.getProjectStartDate();
        this.projectEndDate = project.getProjectEndDate();
    }
}
