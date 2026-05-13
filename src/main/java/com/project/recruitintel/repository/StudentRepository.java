package com.project.recruitintel.repository;

import com.project.recruitintel.entity.StudentProfile;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository
        extends JpaRepository<StudentProfile, Long> {
}