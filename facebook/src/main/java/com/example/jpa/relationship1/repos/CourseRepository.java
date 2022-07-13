package com.example.jpa.relationship1.repos;

import com.example.jpa.relationship1.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Page<Course> findByTitleContaining(String title, Pageable pageable);
}