package com.example.fullusersite.UserDao;

import com.example.fullusersite.User.User;

import java.util.List;

public interface UserDao {
    void save(User user);
    User findByUsername(String username);
    List<User> findAll();
}
