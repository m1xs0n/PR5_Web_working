package com.m1xs0n.pr.service;

import com.m1xs0n.pr.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService {
    Page<Product> getProducts(Optional<String> name, Optional<Double> price, Pageable pageable);
    Optional<Product> getProduct(Long id);
    Product saveProduct(Product product);
    boolean existsById(Long id);
    void deleteProduct(Long id);
}