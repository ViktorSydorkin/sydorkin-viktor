package com.homework5.controller;

import com.homework5.entity.dto.UserDTO;
import com.homework5.entity.exception.ControllerException;
import com.homework5.entity.exception.ServiceException;
import com.homework5.service.inter.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@Api(tags = "API description for User controller")
public class UserController {
    private final UserService userService;

    @ApiOperation("Get user by email")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user/{email}")
    public UserDTO getUserByEmail(@PathVariable String email) {
        try {
            log.info("Get user by email {}", email);
            return userService.getUserByEmail(email);
        } catch (ServiceException serviceException) {
            throw new ControllerException(serviceException.getMessage());
        }

    }

    @ApiOperation("Get all users")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user")
    public List<UserDTO> getAllUsers() {
        try {
            log.info("Get all users");
            return userService.getAllUsers();
        } catch (ServiceException serviceException) {
            throw new ControllerException(serviceException.getMessage());
        }
    }

    @ApiOperation("Create new user")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/user")
    public void createUser(@RequestBody @Valid UserDTO userDTO) {
        try {
            log.info("Add user {}", userDTO);
            userService.saveUser(userDTO);
        } catch (ServiceException serviceException) {
            throw new ControllerException(serviceException.getMessage());
        }
    }

    @ApiOperation("Update user")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/user/")
    public void updateUser(@RequestBody @Valid UserDTO userDTO) {
        try {
            log.info("Update user {}", userDTO);
            userService.saveUser(userDTO);
        } catch (ServiceException serviceException) {
            throw new ControllerException(serviceException.getMessage());
        }
    }

    @ApiOperation("Delete user by id")
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable long id) {
        try {
            log.info("Delete user {}", id);
            userService.deleteUser(id);
        } catch (ServiceException serviceException) {
            throw new ControllerException(serviceException.getMessage());
        }
    }
}
