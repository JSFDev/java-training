package main.com.platzi.appRestCoursesInstructors.services;

import main.com.platzi.appRestCoursesInstructors.entities.InstructorEntity;
import main.com.platzi.appRestCoursesInstructors.repositories.InstructorRepository;
import main.com.platzi.appRestCoursesInstructors.repositories.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InstructorService {
    private static InstructorRepository repository;

    public static InstructorRepository getRepository() {
        return InstructorService.repository;
    }

    @Autowired
    public InstructorService(InstructorRepository repository) {
        InstructorService.repository = repository;
    }

    @RequestMapping(value = "/instructors", method = RequestMethod.GET)
    List<InstructorEntity> getAllInstructors() {
        return InstructorService.repository.findAll();
    }

    @RequestMapping(value = "/instructor", method = RequestMethod.POST)
    ResponseEntity<?> addInstructor(@RequestBody InstructorEntity instructor) {
        InstructorService.repository.save(instructor);
        return new ResponseEntity<>(null, null, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/instructor/{userName}", method = RequestMethod.GET)
    InstructorEntity getInstructorByName(@PathVariable String userName) {
        Validator.validateUser(InstructorService.repository, userName);
        return InstructorService.repository.findByUsername(userName).get();
    }
}
