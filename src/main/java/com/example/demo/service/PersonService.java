package com.example.demo.service;

import com.example.demo.jpa.entity.Person;
import com.example.demo.jpa.repository.PersonJpaRepository;
import com.example.demo.jpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    @Transactional(value = Transactional.TxType.REQUIRED)
    void updatePerson(Long id) {
        Person person = personRepository.findById(id).get();
        person.setName("MyName Hai Dang");
        personRepository.saveAndFlush(person);
    }
}
