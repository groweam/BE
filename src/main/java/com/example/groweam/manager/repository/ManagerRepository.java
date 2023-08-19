package com.example.groweam.manager.repository;

import com.example.groweam.manager.domain.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
