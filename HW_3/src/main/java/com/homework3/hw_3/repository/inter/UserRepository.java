package com.homework3.hw_3.repository.inter;

import com.homework3.hw_3.entity.User;

import java.util.List;

public interface UserRepository {

    User getUserByEmail(String email);

    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(long id);

}
