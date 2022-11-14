package com.mustache.springbootmustache3.repository;

import com.mustache.springbootmustache3.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
