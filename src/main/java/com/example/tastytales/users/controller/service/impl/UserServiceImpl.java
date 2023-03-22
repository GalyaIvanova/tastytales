package com.example.tastytales.users.controller.service.impl;

import com.example.tastytales.users.controller.service.UserService;
import com.example.tastytales.users.module.dao.UserDao;
import com.example.tastytales.users.module.entities.User;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userRepository;

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", String.valueOf(id)));
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        User existingUser=userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", String.valueOf(id)));
        existingUser.setRole(user.getRole());
        existingUser.setJwToken(user.getJwToken());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user=userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", String.valueOf(id)));
        userRepository.delete(user);
    }
}

