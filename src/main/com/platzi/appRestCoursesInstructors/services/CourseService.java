package main.com.platzi.appRestCoursesInstructors.services;

import main.com.platzi.appRestCoursesInstructors.entities.CourseEntity;
import main.com.platzi.appRestCoursesInstructors.repositories.CourseRepository;
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
    private static CourseRepository repository;

    public static CourseRepository getCourseRepository() {
        return CourseService.repository;
    }

    @Autowired
    public CourseService(CourseRepository repository) {
        CourseService.repository = repository;
    }

    @RequestMapping(value = "/instructor/{userName}/courses", method = RequestMethod.GET)
    Collection<CourseEntity> getInstructorCourses(@PathVariable String userName) {
        Validator.validateUser(InstructorService.getRepository(), userName);
        return repository.findByInstructorUsername(userName);
    }

    @RequestMapping(value = "/instructor/{userName}/course/{courseId}", method = RequestMethod.GET)
    CourseEntity getInstructorCourseById(@PathVariable String userName, @PathVariable Long courseId) {
        Validator.validateUser(InstructorService.getRepository(), userName);
        return CourseService.repository.findOne(courseId);
    }

    @RequestMapping(value = "/instructor/{userName}/course", method = RequestMethod.POST)
    ResponseEntity<?> createInstructorCourses(@PathVariable String userName, @RequestBody CourseEntity reqCourse) {
        Validator.validateUser(InstructorService.getRepository(), userName);

        return InstructorService.getRepository()
                .findByUsername(userName)
                .map(instructor -> {
                    CourseEntity course = new CourseEntity(instructor, reqCourse.getDescription());
                    CourseService.repository.save(course);
                    HttpHeaders httpHeaders = new HttpHeaders();

                    httpHeaders.setLocation(ServletUriComponentsBuilder
                            .fromCurrentRequest().path("/{courseId}")
                            .buildAndExpand(course.getId()).toUri());

                    return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
                }).get();
    }
}
