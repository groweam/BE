package com.example.groweam.meeting.domain.entity;

import com.example.groweam.project.domain.entity.Project;
import com.example.groweam.user.domain.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "Meeting")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long meetingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projectId", nullable = false)
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Column(nullable = false)
    private String meetingTitle;

    @Column(nullable = false)
    private LocalDateTime meetingStartDate;

    @Column(nullable = false)
    private LocalDateTime meetingEndDate;

    @Column
    private LocalDateTime startTime;

    @Column
    private LocalDateTime endTime;

    @Column
    private LocalDateTime location;

    @Builder
    public Meeting (Project project, User user, String meetingTitle,
                    LocalDateTime meetingStartDate, LocalDateTime meetingEndDate,
                    LocalDateTime startTime, LocalDateTime endTime, LocalDateTime location) {
        this.project = project;
        this.user = user;
        this.meetingTitle = meetingTitle;
        this.meetingStartDate = meetingStartDate;
        this.meetingEndDate = meetingEndDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
    }

}
