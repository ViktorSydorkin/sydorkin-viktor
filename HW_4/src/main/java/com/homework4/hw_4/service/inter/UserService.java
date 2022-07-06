package com.homework4.hw_4.service.inter;

import com.homework4.hw_4.entity.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO getUserByEmail(String email);

    List<UserDTO> getAllUsers();

    void addUser(UserDTO userDTO);

    void updateUser(UserDTO userDTO);

    void deleteUser(long id);

}
