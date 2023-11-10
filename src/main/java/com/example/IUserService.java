package com.example;

import com.example.domain.User;

import java.util.List;

public interface IUserService {
    void addUser(User user);
    List<User> getAllUsers();
}
