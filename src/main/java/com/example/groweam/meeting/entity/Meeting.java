package com.example.groweam.meeting.entity;

import com.example.groweam.project.entity.Project;
import com.example.groweam.user.entity.User;
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
    @Column
    private Long meetingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project projectId", nullable = false)
    private Project projectId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user userId", nullable = false)
    private User userId;

    @Column
    private String meetingTitle;

    @Column
    private LocalDateTime meetingStartDate;

    @Column
    private LocalDateTime meetingEndDate;

    @Column
    private LocalDateTime startTime;

    @Column
    private LocalDateTime endTime;

    @Column
    private LocalDateTime location;

    @Builder
    public Meeting (Project projectId, User userId, String meetingTitle,
                    LocalDateTime meetingStartDate, LocalDateTime meetingEndDate,
                    LocalDateTime startTime, LocalDateTime endTime, LocalDateTime location) {
        this.projectId = projectId;
        this.userId = userId;
        this.meetingTitle = meetingTitle;
        this.meetingStartDate = meetingStartDate;
        this.meetingEndDate = meetingEndDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
    }

}
