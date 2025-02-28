package com.graduateknowledge.platform.service.impl;

import com.graduateknowledge.platform.model.User;
import com.graduateknowledge.platform.repository.UserRepository;
import com.graduateknowledge.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        // 此处应该实现实际业务逻辑，这里是模拟实现
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        // 模拟实现
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        // 模拟实现
        return userRepository.findByUsername(username);
    }

    @Override
    public User createUser(User user) {
        // 模拟实现
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        // 模拟实现
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        // 模拟实现
        userRepository.deleteById(id);
    }

    @Override
    public boolean isUsernameExists(String username) {
        // 模拟实现
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean isEmailExists(String email) {
        // 模拟实现
        return userRepository.existsByEmail(email);
    }
} 