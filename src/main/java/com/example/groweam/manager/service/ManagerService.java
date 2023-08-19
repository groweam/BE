package com.example.groweam.manager.service;

import com.example.groweam.manager.repository.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ManagerService {

    private final ManagerRepository managerRepository;


}
