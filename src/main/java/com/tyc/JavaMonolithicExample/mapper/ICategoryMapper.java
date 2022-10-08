package com.tyc.JavaMonolithicExample.mapper;

import com.tyc.JavaMonolithicExample.dto.response.FindAllCategoryResponse;
import com.tyc.JavaMonolithicExample.repository.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICategoryMapper {
    ICategoryMapper INSTANCE = Mappers.getMapper(ICategoryMapper.class);

    List<FindAllCategoryResponse> toFindAllCategoryResponse(final List<Category> category);
}
