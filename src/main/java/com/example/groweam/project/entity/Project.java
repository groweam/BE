package com.example.groweam.project.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "Project")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long projectId;

    @Column
    private String projectName;

    @Column
    private String goal;

    @Column
    private String teamName;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm", timezone="Asia/Seoul")
    @Column
    private LocalDateTime projectStartDate;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm", timezone="Asia/Seoul")
    @Column
    private LocalDateTime projectEndDate;

    @Column
    private String projectUrl;

    @Builder
    public Project (String projectName, String goal,
            String teamName, LocalDateTime projectStartDate,
            LocalDateTime projectEndDate, String projectUrl) {
        this.projectName = projectName;
        this.goal = goal;
        this.teamName = teamName;
        this.projectStartDate = projectStartDate;
        this.projectEndDate = projectEndDate;
        this.projectUrl = projectUrl;
    }

}
