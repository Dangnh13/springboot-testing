package com.example.demo.jpa.repository;

import com.example.demo.jpa.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> findAll() {
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("findAllPerson", Person.class);
        return namedQuery.getResultList();
    }

    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }

    public Person insert(Person person) {
        return entityManager.merge(person);
    }

    public Person update(Person person) {
        return entityManager.merge(person);
    }

    public void persist(Person person) {
        // Select before insert and update
//        person = entityManager.merge(person);

        entityManager.persist(person);
//         person.setName("Change name after persist");
        System.out.println("done");
    }


    public void delete(int id) {
        Person person = findById(id);
        entityManager.remove(person);
        System.out.println("Persist done");
    }
}
