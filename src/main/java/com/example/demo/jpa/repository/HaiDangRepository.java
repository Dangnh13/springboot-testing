package com.example.demo.jpa.repository;

import com.example.demo.jpa.entity.HaiDang;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HaiDangRepository extends CrudRepository<HaiDang, Long> {
}
