package com.example.demo.service.impl;

import com.example.demo.jpa.entity.HaiDang;
import com.example.demo.jpa.repository.HaiDangRepository;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private HaiDangRepository haiDangRepository;

    private int id;

    public int getId() {
        return this.id;
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
