package com.example.demo.service;

import com.example.demo.jpa.entity.Product;
import com.example.demo.jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    TestService testService;

    @Transactional(value = Transactional.TxType.REQUIRED)
    public void updateProductName(String newName) {
        Product product = productRepository.findById(1L).get();
        product.setName(newName);
        productRepository.saveAndFlush(product);
        int a = 1/0;
    }
}
