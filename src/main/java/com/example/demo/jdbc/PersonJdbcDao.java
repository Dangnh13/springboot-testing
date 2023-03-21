package com.example.demo.jdbc;

import com.example.demo.jdbc.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonJdbcDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person",
                new BeanPropertyRowMapper<>(Person.class));
    }

    public Person findById(int id) {
        return jdbcTemplate.queryForObject("select * from person where id = ?",
                new BeanPropertyRowMapper<>(Person.class),
                new Object[] {id}
               );
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from person where id = ?",
                new Object[] {id}
        );
    }

    public int deleteAll() {
        return jdbcTemplate.update("delete from person");
    }

}
