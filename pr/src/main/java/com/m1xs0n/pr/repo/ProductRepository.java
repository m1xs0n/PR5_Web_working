package com.m1xs0n.pr.repo;

import com.m1xs0n.pr.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByNameAndPrice(String name, Double price, Pageable pageable);
    Page<Product> findByName(String name, Pageable pageable);
    Page<Product> findByPrice(Double price, Pageable pageable);
}
