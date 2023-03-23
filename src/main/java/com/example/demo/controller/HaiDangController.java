package com.example.demo.controller;

import com.example.demo.service.TestService;
import com.example.demo.service.TransactionTestService;
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

    @Autowired
    TransactionTestService transactionTestService;

    @GetMapping(value = "/")
    public String hello() {
        transactionTestService.update();
        return  "update done";
    }
}
