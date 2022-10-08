package com.tyc.JavaMonolithicExample.service;

import com.tyc.JavaMonolithicExample.repository.IProductRepository;
import com.tyc.JavaMonolithicExample.repository.entity.Product;
import com.tyc.JavaMonolithicExample.utility.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends ServiceManager<Product, Long> {
    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        super(productRepository);
        this.productRepository = productRepository;
    }
}
