package com.AtoZ.abc.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class OrderDto {

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class OrderPostDto {
        private Long userId;
        private List<OrderItemPostDto> orderItemPostDtos = new ArrayList<>();
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderItemPostDto {
        private Long itemId;
        private int orderQuantity;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderResponseDto {
        private int totalPrice;
        private List<OrderItemResponseDto> orderItemResponseDtos;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderItemResponseDto {
        private String itemName;
        private int itemQuantity;
        private int itemPrice;
    }
}
