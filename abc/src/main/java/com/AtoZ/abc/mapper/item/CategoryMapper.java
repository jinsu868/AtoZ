package com.AtoZ.abc.mapper.item;

import com.AtoZ.abc.domain.item.Category;
import com.AtoZ.abc.dto.item.CategoryDto;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    default Category categoryPostDtoToCategory(CategoryDto.CategoryPostDto categoryPostDto) {
        return Category.builder()
                .categoryName(categoryPostDto.getCategoryName())
                .itemCategories(new ArrayList<>())
                .build();
    }

    default CategoryDto.CategoryResponseDto categoryToCategoryResponseDto(Category category) {
        return CategoryDto.CategoryResponseDto.builder()
                .categoryName(category.getCategoryName())
                .ItemNames(category.getItemCategories().stream().map(m -> m.getItem().getName()).collect(Collectors.toList()))
                .build();
    }
}
