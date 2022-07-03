package com.homework3.hw_3.service.inter;

import com.homework3.hw_3.entity.User;
import com.homework3.hw_3.entity.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO getUserByEmail(String email);

    //User getUserByEmailAndPassword(String email, String password);

    List<UserDTO> getAllUsers();

    void addUser(UserDTO userDTO);

    void updateUser(UserDTO userDTO);

    //String passEncryption(String email, String password);

    void deleteUser(long id);
}
