package com.homework6.service.implementation;

import com.homework6.entity.dto.UserDTO;
import com.homework6.entity.exception.RepositoryException;
import com.homework6.entity.exception.ServiceException;
import com.homework6.mappers.UserMapper;
import com.homework6.repository.inter.UserRepository;
import com.homework6.service.inter.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO getUserByEmail(String email) {
        log.info("Get user by email {}", email);
        UserDTO userDTO;
        try {
            userDTO = UserMapper.INSTANCE.toDTO(userRepository.findByEmail(email));
        } catch (RepositoryException r) {
            log.error("Repository has thrown an exception { }", r);
            throw new ServiceException(r.getMessage());
        }
        return userDTO;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        try{
            log.info("Get all users");
            return userRepository.findAll().stream().map(UserMapper.INSTANCE::toDTO).collect(Collectors.toList());
        } catch (RepositoryException r){
            log.error("Repository has thrown an exception { }", r);
            throw new ServiceException(r.getMessage());
        }
    }

    @Override
    public synchronized void saveUser(UserDTO userDTO) {
        log.info("Add user {}", userDTO);
        try {
            userRepository.save(UserMapper.INSTANCE.fromDTO(userDTO));
        } catch (RepositoryException r) {
            log.error("Repository has thrown an exception { }", r);
            throw new ServiceException(r.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public synchronized void deleteUser(long id) {
        log.info("User was removed {}", id);
        try {
            userRepository.delete(userRepository.findById(id).orElseThrow(() -> new RepositoryException("User wasn't found")));
        } catch (RepositoryException r) {
            log.error("Repository has thrown an exception { }", r);
            throw new ServiceException(r.getMessage());
        }
    }
}
