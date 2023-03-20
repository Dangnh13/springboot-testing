package com.example.demo.service;

import com.example.demo.repository.HaiDang;
import com.example.demo.repository.HaiDangRepository;
import com.example.demo.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private HaiDangRepository haiDangRepository;

    private int id;

    public int getId() {
        return this.id;
    }
    @Override
    public String getUsername(String firstName, String lastName) {
        return testRepository.getFullName(firstName, lastName);
    }

    @Override
    public String hello() {
        Iterable<HaiDang> list = haiDangRepository.findAll();
        list.forEach( e -> {
            System.out.println(e.getUsername());
        });
        return "END PROCESS";
    }
}
