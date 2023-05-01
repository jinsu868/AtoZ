package com.AtoZ.abc.service.item;

import com.AtoZ.abc.domain.item.Category;
import com.AtoZ.abc.dto.item.CategoryDto;
import com.AtoZ.abc.mapper.item.CategoryMapper;
import com.AtoZ.abc.repository.item.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
