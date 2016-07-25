package com.platzi.appRestCoursesInstructors.repositories;

import com.platzi.appRestCoursesInstructors.entities.InstructorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InstructorRepository extends JpaRepository<InstructorEntity, Long> {
    Optional<InstructorEntity> findByUsername(String username);
}