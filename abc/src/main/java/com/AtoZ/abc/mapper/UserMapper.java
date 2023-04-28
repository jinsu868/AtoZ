package com.AtoZ.abc.mapper;

import com.AtoZ.abc.domain.User;
import com.AtoZ.abc.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    default User userPostDtoToUser(UserDto.UserPostDto userPostDto) {
        return User.builder()
                .address(userPostDto.getAddress())
                .email(userPostDto.getEmail())
                .loginId(userPostDto.getLoginId())
                .password(userPostDto.getPassword())
                .name(userPostDto.getName())
                .build();
    }

    default UserDto.UserResponseDto userToUserResponseDto(User user) {
        return UserDto.UserResponseDto.builder()
                .loginId(user.getLoginId())
                .email(user.getEmail())
                .name(user.getName())
                .build();
    }
}
