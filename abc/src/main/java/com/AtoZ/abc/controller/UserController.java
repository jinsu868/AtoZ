package com.AtoZ.abc.controller;

import com.AtoZ.abc.dto.UserDto;
import com.AtoZ.abc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    //pass
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/new")
    public UserDto.UserResponseDto createUser(@RequestBody UserDto.UserPostDto userPostDto) {
        return userService.saveUser(userPostDto);
    }

    //pass
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public UserDto.UserResponseDto findUser(@RequestParam Long userId) {
        return userService.findUser(userId);
    }

    //pass
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/edit")
    public UserDto.UserResponseDto updateUser(@RequestParam Long userId, @RequestBody UserDto.UserUpdateDto userUpdateDto) {
        return userService.updateUser(userId, userUpdateDto);
    }

    //pass
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam Long userId) {
        userService.deleteUser(userId);
    }
}
