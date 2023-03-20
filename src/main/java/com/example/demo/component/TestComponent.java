package com.example.demo.component;

import org.springframework.stereotype.Component;

@Component
public class TestComponent {

    public void hello(String uname) {
        System.out.println("Hello: " + uname);
    }
}
