package main.com.platzi.appRestCoursesInstructors.services;

import main.com.platzi.appRestCoursesInstructors.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseService {
    private CourseRepository courseRepository = null;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
}
