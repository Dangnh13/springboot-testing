package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TransactionTestService {

    @Autowired
    PersonService personService;

    @Autowired
    ProductService productService;

    @Transactional(value = Transactional.TxType.SUPPORTS)
    public void update() {
        System.out.println("inside update transaction test service");
        personService.updatePerson(1001L);
        productService.updateProductName("New nameeeee");
        System.out.println("update done!!!!!!!!!");
    }
}
