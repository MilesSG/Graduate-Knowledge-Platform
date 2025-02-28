package com.graduateknowledge.platform.controller;

import com.graduateknowledge.platform.model.StudyResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resources")
public class StudyResourceController {

    @GetMapping
    public ResponseEntity<?> getAllResources(
            @RequestParam(required = false) String type,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        // 模拟实现
        return ResponseEntity.ok("获取所有资源，类型：" + type + "，页码：" + page + "，每页大小：" + size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getResourceById(@PathVariable Long id) {
        // 模拟实现
        return ResponseEntity.ok("获取ID为" + id + "的资源");
    }

    @PostMapping
    public ResponseEntity<?> createResource(@RequestBody StudyResource resource) {
        // 模拟实现
        return ResponseEntity.ok("创建资源成功");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateResource(@PathVariable Long id, @RequestBody StudyResource resource) {
        // 模拟实现
        return ResponseEntity.ok("更新ID为" + id + "的资源成功");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteResource(@PathVariable Long id) {
        // 模拟实现
        return ResponseEntity.ok("删除ID为" + id + "的资源成功");
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchResources(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        // 模拟实现
        return ResponseEntity.ok("搜索关键词为：" + keyword + "的资源，页码：" + page + "，每页大小：" + size);
    }

    @GetMapping("/hot")
    public ResponseEntity<?> getHotResources() {
        // 模拟实现
        return ResponseEntity.ok("获取热门资源");
    }

    @GetMapping("/latest")
    public ResponseEntity<?> getLatestResources() {
        // 模拟实现
        return ResponseEntity.ok("获取最新资源");
    }
} 