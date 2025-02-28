package com.graduateknowledge.platform.repository;

import com.graduateknowledge.platform.model.StudyResource;
import com.graduateknowledge.platform.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudyResourceRepository extends JpaRepository<StudyResource, Long> {
    
    Page<StudyResource> findByResourceType(String resourceType, Pageable pageable);
    
    Page<StudyResource> findByUploader(User uploader, Pageable pageable);
    
    @Query("SELECT sr FROM StudyResource sr WHERE sr.title LIKE %?1% OR sr.description LIKE %?1%")
    Page<StudyResource> searchByKeyword(String keyword, Pageable pageable);
    
    List<StudyResource> findTop5ByOrderByViewCountDesc();
    
    List<StudyResource> findTop5ByOrderByLikeCountDesc();
    
    List<StudyResource> findTop5ByOrderByCreatedAtDesc();
} 