package com.tyc.JavaMonolithicExample.mvcmodels;

import com.tyc.JavaMonolithicExample.dto.response.FindAllCategoryResponse;
import com.tyc.JavaMonolithicExample.repository.entity.Category;
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
public class HomeModel {
    String header;
    List<String> categoryList;
    List<Product> productList;
}
