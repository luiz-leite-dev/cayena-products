package com.cayena.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cayena.products.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
