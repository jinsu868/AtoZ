package com.AtoZ.abc.service;

import com.AtoZ.abc.domain.User;
import com.AtoZ.abc.dto.UserDto;
import com.AtoZ.abc.mapper.UserMapper;
import com.AtoZ.abc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    public UserDto.UserResponseDto saveUser(UserDto.UserPostDto userPostDto) {
        User user = userMapper.userPostDtoToUser(userPostDto);
        return userMapper.userToUserResponseDto(userRepository.save(user));
    }

    public UserDto.UserResponseDto findUser(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return userMapper.userToUserResponseDto(user);
    }

    @Transactional
    public UserDto.UserResponseDto updateUser(Long id, UserDto.UserUpdateDto userUpdateDto) {
        User user = userRepository.findById(id).orElseThrow();
        user.updateUser(userUpdateDto);
        return userMapper.userToUserResponseDto(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
