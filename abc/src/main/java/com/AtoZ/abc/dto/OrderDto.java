package com.AtoZ.abc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class OrderDto {

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class OrderPostDto {
        private Long userId;


    }

}
