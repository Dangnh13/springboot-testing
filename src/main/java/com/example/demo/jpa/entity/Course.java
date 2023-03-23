package com.example.demo.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Course {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
}
