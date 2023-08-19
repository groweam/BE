package com.example.groweam.manager.controller;

import com.example.groweam.manager.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ManagerController {

    private final ManagerService managerService;

}

