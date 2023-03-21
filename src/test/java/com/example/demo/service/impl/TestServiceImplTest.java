package com.example.demo.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.util.ReflectionTestUtils;

@SpringBootTest
class TestServiceImplTest {

    //    @Mock
//    @MockBean used to replace @Mock
//    HaiDangRepository testRepository;

    //    @InjectMocks dont need
    @Autowired
    TestServiceImpl testService;

    @Value("${info.app.name}")
    private String myAppName;
    @BeforeEach
     void beforeAll() {
        ReflectionTestUtils.setField(testService, "id", 100);
    }

    @Test
    @Sql("/insert-sql.sql")
    void testDbInt() {
        System.out.println(testService.hello());
    }
}