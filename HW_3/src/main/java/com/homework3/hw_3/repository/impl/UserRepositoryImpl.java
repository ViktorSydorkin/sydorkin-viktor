package com.homework3.hw_3.repository.impl;

import com.homework3.hw_3.entity.User;
import com.homework3.hw_3.repository.inter.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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
    public void deleteUser(long userId) {
    }
}
