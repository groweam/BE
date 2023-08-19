package com.example.groweam.project.repository;

import com.example.groweam.project.domain.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
