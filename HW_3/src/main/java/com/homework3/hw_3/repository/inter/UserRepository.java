package com.homework3.hw_3.repository.inter;

import com.homework3.hw_3.entity.User;
import com.homework3.hw_3.entity.dto.UserDTO;

import java.util.List;

public interface UserRepository {
    User getUserByEmail(String email);

    //User getUserByEmailAndPassword(String email, String password);

    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(User user);

    //String passEncryption(String email, String password);

    void deleteUser(long id);
}
