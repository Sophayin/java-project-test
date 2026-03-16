
package com.demo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findTopByOrderByIdDesc();
}
