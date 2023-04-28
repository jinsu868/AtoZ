package com.AtoZ.abc.service;

import com.AtoZ.abc.domain.Item.Category;
import com.AtoZ.abc.dto.CategoryDto;
import com.AtoZ.abc.mapper.CategoryMapper;
import com.AtoZ.abc.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryService {

    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    @Transactional
    public CategoryDto.CategoryResponseDto saveCategory(CategoryDto.CategoryPostDto categoryPostDto) {
        Category category = categoryMapper.categoryPostDtoToCategory(categoryPostDto);
        return categoryMapper.categoryToCategoryResponseDto(categoryRepository.save(category));
    }

    public CategoryDto.CategoryResponseDto findCategory(Long id) {
        return categoryMapper.categoryToCategoryResponseDto(categoryRepository.findById(id).orElseThrow());
    }

    @Transactional
    public CategoryDto.CategoryResponseDto updateCategory(Long id, CategoryDto.CategoryUpdateDto categoryUpdateDto) {
        Category category = categoryRepository.findById(id).orElseThrow();
        category.updateCategory(categoryUpdateDto);
        return categoryMapper.categoryToCategoryResponseDto(category);
    }

}
