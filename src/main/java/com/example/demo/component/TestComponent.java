package com.example.demo.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestComponent {

    @Value("${info.app.name}")
    private String myAppName;
    
    public void hello(String uname) {
        System.out.println("Hello: " + uname);
    }
}
