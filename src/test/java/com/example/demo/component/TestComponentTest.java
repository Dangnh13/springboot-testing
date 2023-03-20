package com.example.demo.component;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@TestPropertySource("/application-test.properties")
@SpringBootTest
class TestComponentTest {

    @Value("${info.app.name}")
    private String myAppName;

    @Autowired
    private TestComponent testComponent;

    @BeforeEach
    void beforeEach() {
        System.out.println("Before Each");
    }

    @Test
    void hello() {
        testComponent.hello(myAppName);
        assertEquals(1, 1);
    }
}