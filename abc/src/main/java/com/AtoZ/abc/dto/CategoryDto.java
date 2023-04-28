package com.AtoZ.abc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class CategoryDto {

    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CategoryPostDto {
        private String categoryName;
    }

    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CategoryResponseDto {
        private String categoryName;
        private List<String> ItemNames;
    }

    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CategoryUpdateDto {
        private String categoryName;
    }
}
