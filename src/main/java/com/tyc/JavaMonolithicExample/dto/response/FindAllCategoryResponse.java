package com.tyc.JavaMonolithicExample.dto.response;

import com.tyc.JavaMonolithicExample.repository.entity.Product;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FindAllCategoryResponse {
    private String name;
    private List<Product> product;
}
