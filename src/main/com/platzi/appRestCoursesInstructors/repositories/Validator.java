package main.com.platzi.appRestCoursesInstructors.repositories;

import main.com.platzi.appRestCoursesInstructors.services.ErrorService;

public class Validator {
    public static void validateUser(InstructorRepository instructorRepository, String userId) {
        instructorRepository.findByUsername(userId).orElseThrow(
                () -> new ErrorService(userId));
    }
}
