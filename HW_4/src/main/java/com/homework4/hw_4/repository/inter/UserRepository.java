package com.homework4.hw_4.repository.inter;

import com.homework4.hw_4.entity.User;

import java.util.List;

public interface UserRepository {

    User getUserByEmail(String email);

    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(long id);

}
