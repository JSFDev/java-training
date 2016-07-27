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

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CourseServiceTest extends TestCase {
    private InstructorEntity instructor;
    private Long course1Id;
    private String userName;
    private String password;
    private Collection<CourseEntity> courseList;
    private CourseEntity course1;
    private CourseEntity course2;
    private String courseDescription1;
    private String courseDescription2;

    @Mock
    CourseRepository courseRepository;

    @Mock
    InstructorRepository instructorRepository;

    @InjectMocks
    CourseService courseService;

    @InjectMocks
    InstructorService instructorService;

    private void initializeInstructorAndCourse() {
        course1Id = (long) 12345;
        userName = "username";
        password = "password";
        courseDescription1 = "course description one";
        courseDescription2 = "course description two";
        instructor = new InstructorEntity(this.userName, this.password);
        course1 = new CourseEntity(this.instructor, this.courseDescription1);
        course2 = new CourseEntity(this.instructor, this.courseDescription2);
        courseList = Arrays.asList(course1, course2);
    }

    @Test
    public void shouldReadCourseFromUserNameAndCourseId() {
        CourseEntity restCourse;

        this.initializeInstructorAndCourse();
        when(instructorRepository.findByUsername(this.userName)).thenReturn(Optional.of(this.instructor));
        when(courseRepository.findOne(course1Id)).thenReturn(course1);
        restCourse = courseService.getInstructorCourseById(this.userName, this.course1Id);
        assertEquals(course1.getDescription(), restCourse.getDescription());
    }

    @Test
    public void shouldReadAllCoursesFromUserNameAndCourseId() {
        Collection<CourseEntity> restCourse;

        this.initializeInstructorAndCourse();
        when(instructorRepository.findByUsername(this.userName)).thenReturn(Optional.of(this.instructor));
        when(courseRepository.findByInstructorUsername(this.userName)).thenReturn(courseList);
        restCourse = courseService.getInstructorCourses(userName);
        assertEquals(courseList, restCourse);
    }
}