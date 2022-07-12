package com.homework5.service.implementation;


import com.homework5.entity.dto.UserDTO;
import com.homework5.entity.exception.RepositoryException;
import com.homework5.mappers.UserMapper;
import com.homework5.repository.inter.UserRepository;
import com.homework5.service.inter.UserService;
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
        return UserMapper.INSTANCE.toDTO(userRepository.findByEmail(email));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        log.info("Get all users");
        return userRepository.findAll().stream().map(UserMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public synchronized void saveUser(UserDTO userDTO) {
        log.info("Add user {}", userDTO);
        userRepository.save(UserMapper.INSTANCE.fromDTO(userDTO));
    }

    @Override
    public synchronized void deleteUser(long id) {
        log.info("User was removed {}", id);
        userRepository.delete(userRepository.findById(id).orElseThrow(() -> new RepositoryException("")));
    }
}
