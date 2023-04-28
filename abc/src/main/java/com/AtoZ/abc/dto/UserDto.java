package com.AtoZ.abc.dto;


import com.AtoZ.abc.domain.Address;
import lombok.*;

public class UserDto {

    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserPostDto {
        private String loginId;
        private String password;
        private String name;
        private String email;
        private Address address;
    }

    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserResponseDto {
        private String loginId;
        private String name;
        private String email;
    }

    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserUpdateDto {
        private String name;
        private String email;
    }
}
