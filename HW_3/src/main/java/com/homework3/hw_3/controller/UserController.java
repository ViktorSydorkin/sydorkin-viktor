package com.homework3.hw_3.controller;

import com.homework3.hw_3.entity.dto.UserDTO;
import com.homework3.hw_3.service.inter.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController(value = "/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{email}")
    public UserDTO getUserByEmail(@PathVariable String email) {
        log.info("Get user vy email {}", email);
        return userService.getUserByEmail(email);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<UserDTO> getAllUsers() {
        log.info("Get all users");
        return userService.getAllUsers();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createUser(@RequestBody UserDTO userDTO) {
        log.info("Add user {}", userDTO);
        userService.addUser(userDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public void updateUser(@RequestBody UserDTO userDTO) {
        log.info("Update user {}", userDTO);
        userService.updateUser(userDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        log.info("Delete user {}", id);
        userService.deleteUser(id);
    }
}
