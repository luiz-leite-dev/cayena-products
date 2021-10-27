package com.cayena.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cayena.products.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
