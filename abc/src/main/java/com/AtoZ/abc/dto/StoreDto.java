package com.AtoZ.abc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class StoreDto {

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class StorePostDto {
        String storeName;
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class StoreResponseDto {
        String storeName;
        List<ItemDto.ItemResponseDto> itemResponseDtos;
    }
}
