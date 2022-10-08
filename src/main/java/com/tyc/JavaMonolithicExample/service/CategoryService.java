package com.tyc.JavaMonolithicExample.service;

import com.tyc.JavaMonolithicExample.dto.response.FindAllCategoryResponse;
import com.tyc.JavaMonolithicExample.mapper.ICategoryMapper;
import com.tyc.JavaMonolithicExample.repository.ICategoryRepository;
import com.tyc.JavaMonolithicExample.repository.entity.Category;
import com.tyc.JavaMonolithicExample.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService extends ServiceManager<Category, Long> {
    private final ICategoryRepository categoryRepository;

    public CategoryService(ICategoryRepository categoryRepository) {
        super(categoryRepository);
        this.categoryRepository = categoryRepository;
    }

    public List<FindAllCategoryResponse> findAllCategory() {
        List<FindAllCategoryResponse> categoryResponseList = ICategoryMapper.INSTANCE.toFindAllCategoryResponse(categoryRepository.findAll());
        return categoryResponseList;
    }
}
