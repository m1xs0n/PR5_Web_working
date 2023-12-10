package com.m1xs0n.pr.service;


import com.m1xs0n.pr.model.Product;
import com.m1xs0n.pr.repo.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Service
public class ProductServiceImpl implements com.m1xs0n.pr.service.ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Page<Product> getProducts(Optional<String> name, Optional<Double> price, Pageable pageable) {
        if(name.isPresent() && price.isPresent()) {
            return productRepository.findByNameAndPrice(name.get(), price.get(), pageable);
        } else if(name.isPresent()) {
            return productRepository.findByName(name.get(), pageable);
        } else if(price.isPresent()) {
            return productRepository.findByPrice(price.get(), pageable);
        } else {
            return productRepository.findAll(pageable);
        }
    }

    @Override
    public Optional<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean existsById(Long id) {
        return productRepository.existsById(id);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}