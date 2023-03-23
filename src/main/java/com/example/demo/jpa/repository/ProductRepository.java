package com.example.demo.jpa.repository;

import com.example.demo.jpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**+
 * Dont need specific @Repository and @Transactional on this interface,
 * because it's defined in SimpleJpaRepository class
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
