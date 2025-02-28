package com.graduateknowledge.platform.controller;

import com.graduateknowledge.platform.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        // 模拟实现，实际上会通过UserService调用UserRepository获取数据
        return ResponseEntity.ok("获取所有用户");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        // 模拟实现
        return ResponseEntity.ok("获取ID为" + id + "的用户");
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        // 模拟实现
        return ResponseEntity.ok("创建用户成功");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User user) {
        // 模拟实现
        return ResponseEntity.ok("更新ID为" + id + "的用户成功");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        // 模拟实现
        return ResponseEntity.ok("删除ID为" + id + "的用户成功");
    }
} 