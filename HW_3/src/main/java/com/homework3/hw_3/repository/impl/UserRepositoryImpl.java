package com.homework3.hw_3.repository.impl;

import com.homework3.hw_3.entity.User;
import com.homework3.hw_3.entity.dto.UserDTO;
import com.homework3.hw_3.repository.inter.UserRepository;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(long id) {

    }
}
