package com.tyc.JavaMonolithicExample.controller;

import com.tyc.JavaMonolithicExample.dto.response.FindAllCategoryResponse;
import com.tyc.JavaMonolithicExample.repository.entity.Category;
import com.tyc.JavaMonolithicExample.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.tyc.JavaMonolithicExample.constant.EndPoint.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(CATEGORY)
public class CategoryController {
    private final CategoryService service;

    @GetMapping(SAVE)
    public ResponseEntity<Category> save(String name) {
        Category category = Category.builder()
                .name(name)
                .build();

        return ResponseEntity.ok(service.save(category));
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<FindAllCategoryResponse>> findAll() {
        return ResponseEntity.ok(service.findAllCategory());
    }
}
