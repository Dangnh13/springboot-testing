package com.example.demo.service;

import com.example.demo.repository.TestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.when;

@SpringBootTest
class TestServiceImplTest {

    //    @Mock
    @MockBean
    TestRepository testRepository;

    //    @InjectMocks
    @Autowired
     TestServiceImpl testService;

    @Value("${info.app.name}")
    private String myAppName;
    @BeforeEach
     void beforeAll() {
        ReflectionTestUtils.setField(testService, "id", 100);
    }

    @Test
    void getUsername() {
        System.out.println("ID là: " + testService.getId());
        when(testRepository.getFullName("1", "2")).thenReturn("ngo hai dang 123");
        System.out.println(testService.getUsername("1", "2"));
    }

    @Test
    @Sql("/insert-sql.sql")
    void testDbInt() {
        System.out.println(testService.hello());
    }
}