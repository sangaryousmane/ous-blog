package com.example.jpa.relationship1.repos;

import com.example.jpa.relationship1.entities.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Slice<Product> findByName(String name, Pageable pageable);
}