package com.example.demo.controller;

import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HaiDangController {
    @Value("${info.app.name}")
    private String myAppName;
    @Autowired
    TestService testService;

    @GetMapping(value = "/")
    public String hello() {
        return  testService.hello() + "- " + myAppName;
    }
}
