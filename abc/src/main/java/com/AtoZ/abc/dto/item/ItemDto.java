package com.AtoZ.abc.dto.item;

import lombok.*;

import java.util.List;

public class ItemDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ItemPostDto {
        private Long storeId;
        private String name;
        private int price;
        private int quantity;
        private List<String> categoryNames;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ItemResponseDto {
        private String name;
        private int price;
        private int quantity;
        private List<String> categoryNames;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ItemUpdateDto {
        private String name;
        private int price;
        private int quantity;
        //TODO :: category 변경
    }
}
