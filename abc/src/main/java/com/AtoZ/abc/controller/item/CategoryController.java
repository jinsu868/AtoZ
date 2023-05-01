package com.AtoZ.abc.controller.item;

import com.AtoZ.abc.dto.item.CategoryDto;
import com.AtoZ.abc.service.item.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    //pass
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/new")
    public CategoryDto.CategoryResponseDto createCategory(@RequestBody CategoryDto.CategoryPostDto categoryPostDto) {
        return categoryService.saveCategory(categoryPostDto);
    }

    //pass
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public CategoryDto.CategoryResponseDto findCategory(@RequestParam Long categoryId) {
        return categoryService.findCategory(categoryId);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/edit")
    public CategoryDto.CategoryResponseDto updateCategory(@RequestParam Long categoryId, @RequestBody CategoryDto.CategoryUpdateDto categoryUpdateDto) {
        return categoryService.updateCategory(categoryId, categoryUpdateDto);
    }
}
