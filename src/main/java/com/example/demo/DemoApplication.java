package com.example.demo;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.jpa.entity.Product;
import com.example.demo.jpa.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.jpa.entity.Person;
import com.example.demo.jpa.repository.PersonJpaRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	PersonJpaRepository personJpaRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		List<Person> list = personJpaRepository.findAll();
		System.out.println("size of person: " + list.size());

		Product product= new Product();
		product.setId(1L);
		product.setName("old name");
		product.setDescription("desc");
		product.setImageUrl("URL");
		product.setPrice(new BigDecimal(1));
		product.setSku("SKU");
		productRepository.saveAndFlush(product);

		productService.updateProductName("NEW NAME22");

		Product findPrd = productRepository.findById(1L).get();
		System.out.println(findPrd.getName());

	}

}
