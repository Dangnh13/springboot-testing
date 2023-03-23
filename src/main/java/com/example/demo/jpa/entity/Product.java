package com.example.demo.jpa.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "products", 
uniqueConstraints = {
@UniqueConstraint(name="sku_uq", columnNames = {"stock_keeping_unit"})
})
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "stock_keeping_unit", nullable = false)
	private String sku;
	@Column(nullable = false)
	private String name;
	private String description;
	private BigDecimal price;
	private boolean active;
	private String imageUrl;
	@CreationTimestamp
	private LocalDateTime dateCreated;
	@UpdateTimestamp
	private LocalDateTime lastUpdated;
}
