package com.homework5.service.inter;

import com.homework5.entity.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO getUserByEmail(String email);

    List<UserDTO> getAllUsers();

    void saveUser(UserDTO userDTO);

    void deleteUser(long id);

}
