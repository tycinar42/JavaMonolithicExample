package com.tyc.JavaMonolithicExample.controller;

import com.tyc.JavaMonolithicExample.repository.entity.Product;
import com.tyc.JavaMonolithicExample.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.tyc.JavaMonolithicExample.constant.EndPoint.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(PRODUCT)
public class ProductController {
    private final ProductService service;

    @GetMapping(SAVE)
    public ResponseEntity<Product> save(String brand, String model, Double price, Integer piece, String image) {
        Product product = Product.builder()
                .brand(brand)
                .model(model)
                .price(price)
                .piece(piece)
                .image(image)
                .build();
        return ResponseEntity.ok(service.save(product));
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
