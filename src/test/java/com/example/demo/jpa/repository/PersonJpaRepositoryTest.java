package com.example.demo.jpa.repository;

import com.example.demo.jdbc.PersonJdbcDao;
import com.example.demo.jpa.entity.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(value = {"/application-test-jdbc.properties"})
class PersonJpaRepositoryTest {

    @Autowired
    PersonJpaRepository personJpaRepository;

    @Autowired
    PersonJdbcDao personJdbcDao;

    @AfterEach
    void afterEach() {
        personJdbcDao.deleteAll();
    }

    @Test
    @Sql("/insert-person.sql")
    void findById() {
        Person person = personJpaRepository.findById(1001);
        assertNotNull(person);
    }

    @Test
    @Sql("/insert-person.sql")
    void insertTest() {
        Person person = new Person();
        person.setName("Nguyen ngoc my");
        person.setLocation("Gia trung");
        person.setBirthDate(new Date());
        person = personJpaRepository.insert(person);

        assertEquals(1, person.getId());
    }

    @Test
    @Sql("/insert-person.sql")
    void updateTest() {
        Person person = personJpaRepository.findById(1001);
        person.setName("replace name");
        personJpaRepository.update(person);
        person = personJpaRepository.findById(1001);
        assertEquals("replace name", person.getName());
    }

    @Test
    @Sql("/insert-person.sql")
    void deleteTest() {
        personJpaRepository.delete(1001);
        Person person = personJpaRepository.findById(1001);
        assertNull(person);
    }

    @Test
    @Sql("/insert-person.sql")
    void findAllTest() {
        List<Person> list = personJpaRepository.findAll();
        assertEquals(3, list.size());
    }
}