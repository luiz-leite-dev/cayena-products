package com.cayena.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cayena.products.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
