package main.com.platzi.appRestCoursesInstructors.services;

import main.com.platzi.appRestCoursesInstructors.entities.CourseEntity;
import main.com.platzi.appRestCoursesInstructors.repositories.CourseRepository;
import main.com.platzi.appRestCoursesInstructors.repositories.InstructorRepository;
import main.com.platzi.appRestCoursesInstructors.repositories.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Collection;

@RestController
public class CourseService {
    private CourseRepository courseRepository;
    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @RequestMapping(value = "/instructor/{userName}/courses", method = RequestMethod.GET)
    Collection<CourseEntity> getInstructorCourses(@PathVariable String userName) {
        Validator.validateUser(instructorRepository, userName);
        return courseRepository.findByInstructorUsername(userName);
    }

    @RequestMapping(value = "/instructor/{userName}/course/{courseId}", method = RequestMethod.GET)
    CourseEntity getInstructorCourseById(@PathVariable String userName, @PathVariable Long courseId) {
        Validator.validateUser(instructorRepository, userName);
        return this.courseRepository.findOne(courseId);
    }

    @RequestMapping(value = "/instructor/{userName}/course", method = RequestMethod.POST)
    ResponseEntity<?> createInstructorCourses(@PathVariable String userName, @RequestBody CourseEntity reqCourse) {
        Validator.validateUser(instructorRepository, userName);

        return instructorRepository.findByUsername(userName)
                .map(instructor -> {
                    CourseEntity course = new CourseEntity(instructor, reqCourse.getDescription());
                    HttpHeaders httpHeaders = new HttpHeaders();

                    httpHeaders.setLocation(ServletUriComponentsBuilder
                            .fromCurrentRequest().path("/instructor/{id}")
                            .buildAndExpand(course.getId()).toUri());

                    return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
                }).get();
    }
}
