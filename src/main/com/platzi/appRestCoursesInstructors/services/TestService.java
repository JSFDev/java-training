package main.com.platzi.appRestCoursesInstructors.services;

import main.com.platzi.simple.constants.Messages;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestService {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    String testRest() {
        return Messages.HAPPY_SERVICE_MESSAGE.getValue();
    }
}
