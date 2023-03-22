package com.example.tastytales.users.controller.service;

import com.example.tastytales.users.module.entities.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {

    User getUserById(Long id);

    User createUser(User user);

    User updateUser(Long id, User user);

    void deleteUser(Long id);
}
