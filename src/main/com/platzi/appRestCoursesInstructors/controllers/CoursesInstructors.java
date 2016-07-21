package main.com.platzi.appRestCoursesInstructors.controllers;

import main.com.platzi.simple.constants.Messages;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * RESOURCES
 * /instructors -GET -List<Instructors> getAllInstructors: get all instructor list
 * /instructors -POST -void addInstructor: deserialize instructor by json post and create it.
 * /instructors/test -GET -String testRest: print message to test
 * /instructors/{idUser} -GET -Instructor getInstructorById: get especific instructor by id
 * /instructors/{idUser}/courses -GET -List<Courses> getAllCourses: get all coursees from instructor
 * /instructors/{idUser}/courses -POST -void addCourse: deserialize course by json post and apply to instructor
 * /instructors/{idUser}/courses/{idCourse} -GET - Course getCourseById: get especific course from instructor
 *
 * STATUS CLIENT
 * 201 - request to service success
 * 405 - malformed header http request, send application/json
 */

@RestController
public class CoursesInstructors {

    @RequestMapping(value = "/instructors/test", method = RequestMethod.GET)
    String testRest() {
        return Messages.HAPPY_SERVICE_MESSAGE.getValue();
    }
}
