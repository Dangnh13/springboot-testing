package com.example.demo.jdbc;

import com.example.demo.jdbc.entity.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(value = {"/application-test-jdbc.properties"})
class PersonJdbcDaoTest {

    @Autowired
    PersonJdbcDao personJdbcDao;

    @AfterEach
    void afterEach() {
        personJdbcDao.deleteAll();
    }

    @Test
    @Sql("/insert-person.sql")
    void findAll() {
        List<Person> list = personJdbcDao.findAll();
        assertFalse(list.isEmpty());
    }

    @Test
    @Sql("/insert-person.sql")
    void findById() {
        Person person = personJdbcDao.findById(1001);
        assertNotNull(person);
    }

    @Test
    @Sql("/insert-person.sql")
    void deleteById() {
        int effectRows = personJdbcDao.deleteById(1001);
        assertEquals(1, effectRows);
    }
}