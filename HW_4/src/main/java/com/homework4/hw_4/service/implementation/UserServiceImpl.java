package com.homework4.hw_4.service.implementation;


import com.homework4.hw_4.entity.dto.UserDTO;
import com.homework4.hw_4.mappers.UserMapper;
import com.homework4.hw_4.repository.inter.UserRepository;
import com.homework4.hw_4.service.inter.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO getUserByEmail(String email) {
        log.info("Get user by email {}", email);
        return UserMapper.INSTANCE.toDTO(userRepository.getUserByEmail(email));
    }


    @Override
    public List<UserDTO> getAllUsers() {
        log.info("Get all users");
        return userRepository.getAllUsers().stream().map(UserMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }


    @Override
    public synchronized void addUser(UserDTO userDTO) {
        log.info("Add user {}", userDTO);
        System.out.println("User " + userDTO + " was added");
        userRepository.addUser(UserMapper.INSTANCE.fromDTO(userDTO));
    }


    @Override
    public synchronized void updateUser(UserDTO userDTO) {
        log.info("Update user {}", userDTO);
        System.out.println("User " + userDTO + " was updated");
    }


    @Override
    public synchronized void deleteUser(long id) {
        log.info("User was removed {}", id);
        System.out.println("User " + id + " was removed");
    }
}
