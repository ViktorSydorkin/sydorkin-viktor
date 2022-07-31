package com.homework6.service.inter;

import com.homework6.entity.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO getUserByEmail(String email);

    List<UserDTO> getAllUsers();

    void saveUser(UserDTO userDTO);

    void deleteUser(long id);

}
