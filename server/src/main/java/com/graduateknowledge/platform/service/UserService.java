package com.graduateknowledge.platform.service;

import com.graduateknowledge.platform.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    
    List<User> getAllUsers();
    
    Optional<User> getUserById(Long id);
    
    Optional<User> getUserByUsername(String username);
    
    User createUser(User user);
    
    User updateUser(User user);
    
    void deleteUser(Long id);
    
    boolean isUsernameExists(String username);
    
    boolean isEmailExists(String email);
} 