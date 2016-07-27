package com.platzi.appRestCoursesInstructors.services;

import com.platzi.appRestCoursesInstructors.entities.CourseEntity;
import com.platzi.appRestCoursesInstructors.entities.InstructorEntity;
import com.platzi.appRestCoursesInstructors.repositories.CourseRepository;
import com.platzi.appRestCoursesInstructors.repositories.InstructorRepository;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CourseServiceTest extends TestCase {
    private InstructorEntity instructor;
    private CourseEntity course;
    private Long courseId = (long) 12345;
    private String userName = "username";
    private String password = "password";
    private String courseDescription = "course description";

    @Mock
    CourseRepository courseRepository;

    @Mock
    InstructorRepository instructorRepository;

    @InjectMocks
    CourseService courseService;

    @InjectMocks
    InstructorService instructorService;

    private void createMockInstructorAndCourse() {
        instructor = new InstructorEntity(this.userName, this.password);
        course = new CourseEntity(this.instructor, this.courseDescription);
        when(instructorRepository.findByUsername(this.userName)).thenReturn(Optional.of(this.instructor));
        when(courseRepository.findOne(courseId)).thenReturn(course);
    }

    @Test
    public void shouldReadCourseFromUserName() {
        this.createMockInstructorAndCourse();
        CourseEntity restCourse = courseService.getInstructorCourseById(this.userName, courseId);
        assertEquals(course.getDescription(), restCourse.getDescription());
    }
}