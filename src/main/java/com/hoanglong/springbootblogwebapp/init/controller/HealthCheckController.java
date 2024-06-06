package com.hoanglong.springbootblogwebapp.init.controller;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/${application.version}/health")
public class HealthCheckController {
    @GetMapping()
    public String HealthCheck(){
        return "App is running";
    }
}
