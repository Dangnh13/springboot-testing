package com.example.demo.jpa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQuery(name = "findAllPerson", query = "select p from Person p")
@EqualsAndHashCode
@Getter
@Setter
@Data
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String location;
    private Date birthDate;
}
