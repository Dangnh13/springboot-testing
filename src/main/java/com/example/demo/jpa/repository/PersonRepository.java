package com.example.demo.jpa.repository;

import com.example.demo.jpa.entity.Person;
import com.example.demo.jpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**+
 * Dont need specific @Repository and @Transactional on this interface,
 * because it's defined in SimpleJpaRepository class
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
}
