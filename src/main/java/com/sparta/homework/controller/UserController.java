package com.sparta.homework.controller;

import com.sparta.homework.domain.User;
import com.sparta.homework.domain.UserRepository;
import com.sparta.homework.domain.UserRequestDto;
import com.sparta.homework.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping("/api/users")
    public List<User> getUsers() {
        return userRepository.findAllByOrderByModifiedAtDesc();
    }

    @PostMapping("/api/users")
    public User createUser(@RequestBody UserRequestDto requestDto) {
        User user = new User(requestDto);
        return userRepository.save(user);
    }

    @DeleteMapping("/api/users/{id}")
    public Long deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return id;
    }

    @PutMapping("/api/users/{id}")
    public Long updateUser(@PathVariable Long id, @RequestBody UserRequestDto requestDto){
        userService.update(id,requestDto);
        return id;
    }
}