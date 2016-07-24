package main.com.platzi.appRestCoursesInstructors.repositories;

import main.com.platzi.appRestCoursesInstructors.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
    Collection<CourseEntity> findByInstructorUsername(String username);
}
