package com.example.groweam.todo.repository;

import com.example.groweam.todo.domain.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
